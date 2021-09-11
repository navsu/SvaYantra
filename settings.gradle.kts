rootProject.name = "SvaYantra"
include(
    ":app",
    ":android-core:android-core-adapter",
    ":android-core:android-core-viewbinding",

    ":core:core-dispatchers",
    ":core:core-domain",
    ":core:core-result",
    ":core:core-usecase",

    ":svayantra-stack:db-svayantra",
    ":svayantra-stack:localrepo-svayantra",
    ":svayantra-stack:remoterepo-svayantra",
    ":svayantra-stack:usecase-svayantra",

    ":ui:ui-dashboard",
    ":ui:ui-home"
)

