import sbt.*

object Dependencies {
  val jdkVersion = "17"
  val scalaVersion = "2.13.15"

  // Determine OS version of JavaFX binaries
  private lazy val platformName: String = (System.getProperty("os.name"), System.getProperty("os.arch")) match {
    case (name, arch) if name.startsWith("Linux")                   => "linux"
    case (name, arch) if name.startsWith("Mac") && arch == "x86_64" => "mac"
    case (name, arch) if name.startsWith("Mac")                     => "mac-" + arch
    case (name, arch) if name.startsWith("Windows")                 => "win"
    case (name, arch) => throw new Exception(s"Unknown platform! name = $name; arch = $arch")
  }

  val openjfxVersion = "21.0.5"
  val javaFXModuleNames: Seq[String] = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
  val javaFXModules: Seq[ModuleID] = javaFXModuleNames.map(m =>
    "org.openjfx" % s"javafx-$m" % openjfxVersion classifier platformName
  )

  val typesafeConfigVersion = "1.4.3"
  val typesafeConfig = "com.typesafe" % "config" % typesafeConfigVersion

  val exampleDependencies: Seq[ModuleID] = Seq(
    typesafeConfig,
  ) ++ javaFXModules
}
