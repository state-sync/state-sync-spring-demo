package org.statesync.spring.demo.util;

import java.util.function.Supplier;

public class LazyValue<T> {
	private volatile T value;

	public T get(final Supplier<T> supplier) {
		if (this.value == null) {
			synchronized (this) {
				this.value = supplier.get();
			}
		}
		return this.value;
	}
}
