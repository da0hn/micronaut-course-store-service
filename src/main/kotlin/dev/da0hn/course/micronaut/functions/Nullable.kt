package dev.da0hn.course.micronaut.functions


inline fun <T> T?.orElseThrow(throwable: () -> Throwable): T {
  if (this == null) {
    throw throwable()
  }
  return this
}

