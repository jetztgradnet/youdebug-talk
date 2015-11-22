// this script is meant to be used from with GroovyConsole
//
// How to use:
// 1. put youdebug.jar, args4.jar and tools.jar (from the JDK) on the classpath (Script menu)
// 2. simply put your debug script into the closure below 
// 3. execute the script from within GroovyConsole
// 4. interrupt script execution when no longer needed
// 5. rinse and repeat 

import org.kohsuke.youdebug.*

// connect to JVM and run debug script
VM vm = VMFactory.connectRemote("localhost", 8001);



def debug = {
	// TODO put your debug script here
	println vm.virtualMachine.description()
	

}




// run debug script
try {
	use (org.kohsuke.youdebug.JDICategory) {
		debug.run()
		vm.dispatchEvents()
	}
}
finally {
	vm.close()
}