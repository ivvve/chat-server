package com.tistory.devs0n.domain.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(scanBasePackageClasses = [DomainChatModule::class])
class DomainChatModule

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DomainChatModule::class)
annotation class EnableDomainChatModule
