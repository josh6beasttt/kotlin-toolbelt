package com.kevinmost.kotlin_toolbelt.extension

// There's no stdlib method that doesn't return a new list. We want to keep this as an array for
// the sake of efficiency sometimes.
inline fun <T, reified R> Array<out T>.mapToArray(transform: (T) -> R): Array<R> {
  val result = arrayOfNulls<R>(this.size)
  for (i in 0..size - 1) {
    result[i] = transform(this[i])
  }
  @Suppress("CAST_NEVER_SUCCEEDS") // yes it does
  return result as Array<R>
}

inline fun <T, reified R> mapEach(vararg elements: T, mapFunction: (T) -> R): Array<R> {
  return elements.mapToArray(mapFunction)
}
