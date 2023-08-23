plugins {
   id("maven-publish")
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.3"
   id("us.ihmc.ihmc-cd") version "1.26"
}

ihmc {
   group = "us.ihmc"
   version = "2.1.6"
   vcsUrl = "https://github.com/ihmcrobotics/ihmc-video-codecs"
   openSource = true

   configureDependencyResolution()
   //javaDirectory("main", "examples")
   javaDirectory("main", "swig/generated")
   //configurePublications()
}

mainDependencies {
   implementation("org.apache.commons:commons-compress:1.23.0")
}

tasks.withType<JavaCompile> {
   options.encoding = "UTF-8"
   options.release = 8
}

// CUSTOM VERSION AND PUBLISHING CODE
//
version = "2.2.0-SNAPSHOT"
publishing {
   repositories {
      maven {
         val folder = if (version.toString().contains("SNAPSHOT")) "libs-snapshot-local" else "libs-release-local"
         url = uri("${project.property("artifactory_url")}/$folder")
         isAllowInsecureProtocol = true
         credentials {
            username = project.property("artifactory_user").toString()
            password = project.property("artifactory_password").toString()
         }
      }
   }
   publications {
      create<MavenPublication>("maven") {
         from(components["java"])
         groupId = project.property("artifactory_group").toString()
         versionMapping {
            usage("java-api") {
               fromResolutionResult()
            }
            usage("java-runtime") {
               fromResolutionResult()
            }
         }
      }
   }
}
