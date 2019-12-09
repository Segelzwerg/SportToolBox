# Contribution

Thank you very much for contributing.

## How to?

* Please fork the project
* Work on the code in the fork
* Create a Pull Request to the main project

### Testing

If you implement or change code, please run the tests so we can avoid regression. Preferably create tests before working on the code. It is also possible to create tests without adding new code.
This projects uses mockito and hamcrest.

### Working on issues

Please comment on an issue before starting work. This way nobody is wasting time trying to achieve the same thing.

### Coding

Please use Java Coding Conventions so the code is easily readable for everyone.

#### Commits

Use many small commits during development. Each commit should handle only logical connected change.

#### Controller

Use for the Translator for returning from a Controller.

```
return Translator.toLocale("message");
```

#### Front End

Make the changes on the main files outside the language specific folders unless it is a translation. These should only be made inside the language folders.


### Pull Requests

Please provide a small description as to what you have done and reference any  existing issues you have resolved.
Please don't forget to comment PRs with `@all-contributors please add <username> for <contributions>` in order to update the all contributors list.
