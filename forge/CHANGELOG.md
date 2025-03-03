# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project does not adhere to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).
This project uses MCVERSION-MAJORMOD.MAJORAPI.MINOR.PATCH.

## [1.17.1-3.0.0.0] - 2021.09.23
### Added
- Added `RenderCapeEvent` to allow easy cancellation of cape rendering for mods that need the functionality
### Removed
- Removed `RenderElytraEvent`, mods should just create their own elytra layers
- Removed elytra tagging system

## [1.16.5-2.1.3.1] - 2021.07.28
### Added
- Added German localization (thanks muffinbarde!) [#20](https://github.com/TheIllusiveC4/Caelus/pull/20)

## [1.16.5-2.1.3.0] - 2021.03.02
### Added
- [API] Added item tag `elytra_like` for stateless elytra flight implementations
### Fixed
- Fixed elytras working while broken

## [1.16.5-2.1.2.2] - 2021.01.21
### Fixed
- Fixed colored elytra texture rendering

## [1.16.5-2.1.2.1] - 2021.01.21
### Fixed
- Fixed elytra rendering

## [1.16.5-2.1.2.0] - 2021.01.21
### Added
- Added color overrides to RenderElytraEvent

## [1.16.5-2.1.1.0] - 2021.01.21
### Added
- Added taggable elytra implementations with "forge:elytra"

## [1.16.4-2.1.0.2] - 2021.01.06
### Fixed
- Fixed enchantment glint not being applied to the render layer

## [1.16.4-2.1.0.1] - 2021.01.06
### Fixed
- Fixed incorrect mixin injection

## [1.16.4-2.1.0.0] - 2020.11.16
### Changed
- Updated to 1.16.4

## [1.16.3-2.0.0.3] - 2020.09.29
### Fixed
- Fixed FML injection crash [#11](https://github.com/TheIllusiveC4/Caelus/issues/11)

## [1.16.3-2.0.0.2] - 2020.09.27
### Fixed
- Fixed jar build

## [1.16.3-2.0.0.1] - 2020.09.27
### Changed
- Updated to 1.16.3

## [1.16.2-2.0.0.0] - 2020.08.14
### Changed
- Updated to 1.16.2

## [2.0-beta7] - 2020.08.07
### Fixed
- Fixed dedicated server crash [#8](https://github.com/TheIllusiveC4/Caelus/issues/8)

## [2.0-beta6] - 2020.08.06
### Changed
- Updated to Forge 32.0.101+
- Javascript coremods replaced with mixins

## [2.0-beta5] - 2020.07.14
### Fixed
- Fixed NoClassDefFoundError

## [2.0-beta4] - 2020.06.11
### Added
- [API] Added RenderElytraEvent for rendering non-vanilla elytras, including enchantment glow and custom textures
### Changed
- Ported to 1.16.1 Forge
### Removed
- Removed elytra rendering IMC in favor of bringing back RenderElytraEvent
- Removed all advanced elytra controls (these will return in a separate mod TBA)
