package com.iamceph.resulter.core.pack;

/**
 * A wrapper for .proto conversions.
 *
 * @param <T> .proto type of this class
 */
public interface ProtoWrapper<T> {
    /**
     * Wraps current wrapper into a .proto class
     *
     * @return .proto class
     */
    T asProto();
}
