set ns [new Simulator]

set tr [open Lab08.tr w]
set nam [open Lab08.nam w]
$ns trace-all $tr
$ns namtrace-all $nam

proc Finish {} {
    global ns tr nam
    $ns flush-trace
    close $tr
    close $nam
    exec nam Lab08.nam &
    
    if {[catch {exec grep -c "^d" Lab08.tr} drops]} {
        puts "Drop count unavailable (grep not found)"
    } else {
        puts "Total packets dropped: $drops"
    }
    exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

$n0 label "TCP Source"
$n2 label "TCP Sink"

foreach {a b} {n0 n1  n1 n2} {
    $ns duplex-link [set $a] [set $b] 1Mb 10ms DropTail
    $ns duplex-link-op [set $a] [set $b] orient right
}
$ns queue-limit $n0 $n1 10
$ns queue-limit $n1 $n2 10

set tcp0 [new Agent/TCP]
set sink0 [new Agent/TCPSink]
$ns attach-agent $n0 $tcp0
$ns attach-agent $n2 $sink0
$ns connect $tcp0 $sink0
$tcp0 set class_ 1

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 100
$cbr0 set rate_ 1Mb
$cbr0 attach-agent $tcp0

$ns at 0.0 "$cbr0 start"
$ns at 5.0 "Finish"

$ns run
