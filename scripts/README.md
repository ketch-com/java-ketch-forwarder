# scripts

This folder contains build and utility scripts.

## build.sh

This script builds the binaries for the repository, if any are produced.

To build all platforms, use the following:
```shell
./scripts/build.sh
```

To build specific platform (e.g., `linux` and `darwin`), use the following:
```shell
./scripts/build.sh linux darwin
```

## bumpdep.sh

This script bumps dependencies.

If you have a clean local source, you can create a dependency branch and push to origin using the following:
```shell
./scripts/bumpdep.sh
```

To bump dependencies in your local, without creating a separate git branch, use the following:
```shell
./scripts/bumpdep.sh --local
```

## generate.sh

This script generates code and is used by `generate.go`.

To generate everything, use the following:

```shell
./scripts/generate.sh
```

To run a specific generator (e.g., `mocks`), use the following:

```shell
./scripts/generate.sh mocks
```

To specify multiple generators (e.g., `gateway` and `proto`), use the following:

```shell
./scripts/generate.sh gateway proto
```
