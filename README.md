# Team SMP Monorepo

This is now where the Team SMP's code is stored: an amazing monorepo!

## Contributing

We are using the Git Flow workflow, which is a development workflow where all new features are developed in their own branches. This is the kind of format you want when creating a new flow branch:

```
testium-26-recalculate-splines
```

In this format, the first segment is the name of the project (because this is a monorepo), the second is a number that increments with each flow branch across projects, and the third onwards is a description of the features to be introduced in the branch.

We also prefer to use Conventional Commits, where each commit has a type, scope, header, body and optionally a footer. Here's an example:

```
feat(testium): recalculate splines

This change recalculates all of those
legendary splines! Completely new and
completely random numbers for your
pleasure.

Fix: #82
```

As you can see, the commit message has a type of `feat`, meaning "feature" and a scope of `testium`, which means that this commit made changes to the "testium" project. The body is self-explanatory, and you can see that the footer tells you this commit fixes an issue
