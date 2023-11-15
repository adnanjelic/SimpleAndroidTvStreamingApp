plugins {
    alias(libs.plugins.android.application) apply(false)
    alias(libs.plugins.kotlin.android) apply(false)
    alias(libs.plugins.hilt) apply(false)
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply(false)
    alias(libs.plugins.kotlin.jvm) apply(false)
    alias(libs.plugins.ktlint) apply(false)
}

val installGitHook = tasks.register<Copy>("installGitHook") {
    from(File(rootProject.rootDir, "automation/pre-commit"))
    into(File(rootProject.rootDir, ".git/hooks"))
    fileMode = 0b111111101
}

tasks.getByPath(":app:preBuild").dependsOn(installGitHook)
