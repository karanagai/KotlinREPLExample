package jetbrains.kotlinreplexample

import java.io.BufferedReader
import java.io.InputStreamReader
import javax.script.ScriptEngineManager


fun main(args: Array<String>) {
    System.setProperty("idea.use.native.fs.for.win", "false")
    val mgr = ScriptEngineManager()

    val factories = mgr.engineFactories

    /* for information purposes only */
    for (factory in factories) {
        println("ScriptEngineFactory Info")
        val engName = factory.engineName
        val engVersion = factory.engineVersion
        val langName = factory.languageName
        val langVersion = factory.languageVersion
        System.out.printf("\tScript Engine: %s (%s)%n", engName, engVersion)
        val engNames = factory.names
        for (name in engNames) {
            System.out.printf("\tEngine Alias: %s%n", name)
        }
        System.out.printf("\tLanguage: %s (%s)%n", langName, langVersion)
    }

    val engine = mgr.getEngineByExtension("kts")

    if (engine == null) {
        println("ERROR: No script engine available!");
        return;
    }

    engine.eval("import jetbrains.kotlinreplexample.*")

    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        println("\n------")
        println("Aloha!")
        println("------\n")

        while (true) {
            print("(${data.size} items) :> ")

            val line = reader.readLine() ?: break

            if (line == ":quit") {
                println("\nBye!")
                break
            }

            try {
                val result = engine.eval(line)
                if (result != null) println(result)
            } catch (ex: Exception) {
                println(ex)
            }
        }
    }
}