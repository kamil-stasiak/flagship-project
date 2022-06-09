# TODO

Tests

- [x] testContainers
- [ ] mutation testing
- [x] property based testing
  - https://johanneslink.net/property-based-testing-in-kotlin/
  - https://github.com/jlink/property-based-testing-in-kotlin
- [ ] model based testing
- [ ] kover

Db
- [ ] test containers outside test (in development, like postgres, kafka)
- [ ] connection pool
- [ ] transactions

  Architecture

- [ ] modular monolith
- [ ] hexagonal modules
- [x] gradle modules separations
- [ ] event sourcing
- [ ] many entry points: http (ktor, spring, quarkus), CLI

  Arrow

- [x] new arrow core syntax (with context receivers)
- [ ] optics
- [ ] fx
- [ ] analysis

  Other

- [x] context receivers
- [x] ktor (auto reload)
- [ ] quarkus (livereload)
- [ ] SQLDelight
- [ ] Jooq
- [ ] ktlint (or something like that)
- [ ] detekt (static code analysis tool https://github.com/detekt/detekt)
- [ ] value classes instead of String in ids
- [ ] kotlin native (eg. ktor) - kotlin multiplatform plugin instead kotlin jvm

