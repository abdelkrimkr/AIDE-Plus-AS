// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.devtoolsKsp) apply false
    alias(libs.plugins.baseLineprofile) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.googleDagge) apply false
    alias(libs.plugins.kotlinComposeCompiler) apply false
    id("build-logic.project")
}

buildscript {
    dependencies {
        //BlackObfuscator(https://github.com/CodingGay/BlackObfuscator-ASPlugin)
        classpath(libs.io.github.blackObfuscator.asPlugin)

    }
}


tasks.register<Delete>("clean").configure {
    delete(rootProject.layout.buildDirectory)
    delete(rootDir.resolve("AIDELibrary"))
    delete(rootDir.resolve("Submodule/AIDE/app_rewrite/res"))
    delete(rootDir.resolve("Submodule/AIDE/app_rewrite/AndroidManifest.xml"))
    delete(rootDir.resolve("Submodule/AIDE/appAideBase/res"))
    delete(rootDir.resolve("Submodule/AIDE/appAideBase/AndroidManifest.xml"))

}
