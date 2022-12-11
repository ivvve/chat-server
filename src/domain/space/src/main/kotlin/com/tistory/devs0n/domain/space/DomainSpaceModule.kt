package com.tistory.devs0n.domain.space

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(scanBasePackageClasses = [DomainSpaceModule::class])
class DomainSpaceModule

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DomainSpaceModule::class)
annotation class EnableDomainSpaceModule
