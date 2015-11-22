// this script is meant to be used from with GroovyConsole
//
// How to use:
// 1. put youdebug.jar, args4.jar and tools.jar (from the JDK) on the classpath (Script menu)
// 2. simply put your debug script into the closure below 
// 3. execute the script from within GroovyConsole
// 4. interrupt script execution when no longer needed
// 5. rinse and repeat 

import org.kohsuke.youdebug.*

try {
    use (JDICategory) {
    // connect to JVM and run debug script
vm = VMFactory.connectRemote("localhost", 8001);
// run debug script
        def debug = {
            use (JDICategory) {
                // TODO put your debug script here
                vm.resume()
                println "tracing web requests"
                vm.methodEntryBreakpoint("javax.servlet.http.HttpServlet","service") { method ->
                    def request = JDICategory.propertyMissing(thread.frame(0),'0')
                
                    println method
                    println request.getMethod() + " " + request.getRequestURI() 
                }
            }
        }

        
        debug.call()
        vm.dispatchEvents()
    }
}
finally {
    vm.close()
}