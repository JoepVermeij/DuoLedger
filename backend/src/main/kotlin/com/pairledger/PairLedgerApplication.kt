package com.pairledger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PairLedgerApplication

fun main(args: Array<String>) {
    runApplication<PairLedgerApplication>(*args)
}
