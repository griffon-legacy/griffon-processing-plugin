griffon.project.dependency.resolution = {
    inherits("global")
    log "warn"
    repositories {
        griffonHome()
        mavenCentral()
        mavenRepo 'http://repository.sonatype.org/content/groups/public'
        String basePath = pluginDirPath? "${pluginDirPath}/" : ''
        flatDir name: "processingLibDir", dirs: ["${basePath}lib"]
    }
    dependencies {
        def processingVersion = '1.5.1'
        compile "org.processing:processing-core:$processingVersion"
        runtime "org.processing:processing-net:$processingVersion",
                "org.processing:processing-opengl:$processingVersion",
                "org.processing:processing-pdf:$processingVersion",
                "org.processing:processing-dxf:$processingVersion",
                "org.processing:processing-serial:$processingVersion",
                "org.processing:processing-video:$processingVersion"
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon.codehaus.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (@griffon.version@)"
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}