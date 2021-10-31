// write the classes here
@Suppress("unused")
class OperatingSystem {
    var name: String = ""
}

@Suppress("unused")
class DualBoot {
    var primaryOs: OperatingSystem = OperatingSystem()
    var secondaryOs: OperatingSystem = OperatingSystem()
}
