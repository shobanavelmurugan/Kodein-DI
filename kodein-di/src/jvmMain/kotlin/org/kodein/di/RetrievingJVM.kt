package org.kodein.di

//region DI
/**
 * Gets all factories that match the the given argument type, return type and tag.
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the factories take.
 * @param T The type of object to retrieve with the factories.
 * @param tag The bound tag, if any.
 * @return A list of factories of [T].
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DIAware.allFactories(tag: Any? = null) = AllFactories<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag)

/**
 * Gets all providers that match the the given return type and tag.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @return A list of providers of [T].
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> DIAware.allProviders(tag: Any? = null) = AllProviders<T>(org.kodein.type.generic(), tag)

/**
 * Gets all providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of providers of [T].
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DIAware.allProviders(tag: Any? = null, arg: A) = AllProviders<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag) { arg }

/**
 * Gets all providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * The argument type is extracted from the `Typed.type` of the argument.
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of providers of [T].
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <A, reified T : Any> DIAware.allProviders(tag: Any? = null, arg: Typed<A>) = AllProviders<A, T>(arg.type, org.kodein.type.generic(), tag) { arg.value }

/**
 * Gets all providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param fArg A function that returns the argument that will be given to the factory when curried.
 * @return A list of providers of [T].
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DIAware.allProviders(tag: Any? = null, noinline fArg: () -> A) = AllProviders<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag, fArg)

/**
 * Gets all instances from providers that match the the given return type and tag.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @return A list of [T] instances.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> DIAware.allInstances(tag: Any? = null) = AllInstances<T>(org.kodein.type.generic(), tag)

/**
 * Gets all instances from providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of [T] instances.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DIAware.allInstances(tag: Any? = null, arg: A) = AllInstances<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag) { arg }

/**
 * Gets all instances from providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * The argument type is extracted from the `Typed.type` of the argument.
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of [T] instances.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <A, reified T : Any> DIAware.allInstances(tag: Any? = null, arg: Typed<A>) = AllInstances<A, T>(arg.type, org.kodein.type.generic(), tag) { arg.value }

/**
 * Gets all instances from providers that match the the given return type and tag, curried from factories that take an argument [A].
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the curried factories take.
 * @param T The type of object to retrieve with the providers.
 * @param tag The bound tag, if any.
 * @param fArg A function that returns the argument that will be given to the factory when curried.
 * @return A list of [T] instances.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DIAware.allInstances(tag: Any? = null, noinline fArg: () -> A) = AllInstances<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag, fArg)
//endregion

//region DirectDI
/**
 * Gets all factories that can return a `T` for the given argument type, return type and tag.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @return A list of matching factories of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A: Any, reified T : Any> DirectDIAware.allFactories(tag: Any? = null) = directDI.AllFactories<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag)

/**
 * Gets all providers that can return a `T` for the given type and tag.
 *
 * T generics will be erased.
 *
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @return A list of matching providers of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> DirectDIAware.allProviders(tag: Any? = null) = directDI.AllProviders<T>(org.kodein.type.generic(), tag)

/**
 * Gets all providers that can return a `T` for the given type and tag, curried from factories for the given argument.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of matching providers of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DirectDIAware.allProviders(tag: Any? = null, arg: A) = directDI.AllProviders<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag) { arg }

/**
 * Gets all providers that can return a `T` for the given type and tag, curried from factories for the given argument.
 *
 * The argument type is extracted from the `Typed.type` of the argument.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @param arg The argument that will be given to the factory when curried.
 * @return A list of matching providers of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <A, reified T : Any> DirectDIAware.allProviders(tag: Any? = null, arg: Typed<A>) = directDI.AllProviders<A, T>(arg.type, org.kodein.type.generic(), tag) { arg.value }

/**
 * Gets all providers that can return a `T` for the given type and tag, curried from factories for the given argument.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @param fArg A function that returns the argument that will be given to the factory when curried.
 * @return A list of matching providers of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A: Any, reified T : Any> DirectDIAware.allProviders(tag: Any? = null, noinline fArg: () -> A) = directDI.AllProviders<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag, fArg)

/**
 * Gets all instances that can return a `T` for the given type and tag.
 *
 * T generics will be erased.
 *
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @return A list of matching instances of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> DirectDIAware.allInstances(tag: Any? = null) = directDI.AllInstances<T>(org.kodein.type.generic(), tag)

/**
 * Gets all instances that can return a `T` for the given type and tag, curried from factories for the given argument.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @param arg A function that returns the argument that will be given to the factory when curried.
 * @return A list of matching instances of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A: Any, reified T : Any> DirectDIAware.allInstances(tag: Any? = null, arg: A) = directDI.AllInstances<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag, arg)

/**
 * Gets all instances that can return a `T` for the given type and tag, curried from factories for the given argument.
 *
 * The argument type is extracted from the `Typed.type` of the argument.
 *
 * A & T generics will be erased.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @param arg A function that returns the argument that will be given to the factory when curried.
 * @return A list of matching instances of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <A, reified T : Any> DirectDIAware.allInstances(tag: Any? = null, arg: Typed<A>) = directDI.AllInstances<A, T>(arg.type, org.kodein.type.generic(), tag, arg.value)


/**
 * Gets a factory of `T` for the given argument type, return type and tag.
 *
 * A & T generics will be preserved.
 *
 * @param A The type of argument the factory takes.
 * @param T The type of object the factory returns.
 * @param tag The bound tag, if any.
 * @return A factory.
 * @throws DI.NotFoundException if no factory was found.
 * @throws DI.DependencyLoopException When calling the factory function, if the instance construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DirectDI.factory(tag: Any? = null) = Factory<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag)

/**
 * Gets all factories that can return a `T` for the given argument type, return type and tag.
 *
 * A & T generics will be preserved.
 *
 * @param A The type of argument the returned factory takes.
 * @param T The type of object to retrieve with the returned factory.
 * @param tag The bound tag, if any.
 * @return A list of matching factories of `T`.
 * @throws DI.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A : Any, reified T : Any> DirectDI.allFactories(tag: Any? = null) = AllFactories<A, T>(org.kodein.type.generic(), org.kodein.type.generic(), tag)
//endregion