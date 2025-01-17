package com.iamceph.resulter.core.model;

import com.iamceph.resulter.core.DataResultable;
import com.iamceph.resulter.core.api.ResultStatus;
import com.iamceph.resulter.core.api.provider.DataResulterProvider;

final class DataResulterProviderImpl implements DataResulterProvider {

    private DataResulterProviderImpl() {
    }

    static DataResulterProvider get() {
        return new DataResulterProviderImpl();
    }

    @Override
    public <T> DataResultable<T> ok(T data) {
        return new DataResultableImpl<>(ResultStatus.OK, "Ok.", null, data);
    }

    @Override
    public <T> DataResultable<T> ok(T data, String message) {
        return new DataResultableImpl<>(ResultStatus.OK, message, null, data);
    }

    @Override
    public <T> DataResultable<T> fail(String message) {
        return new DataResultableImpl<>(ResultStatus.FAIL, message, null, null);
    }

    @Override
    public <T> DataResultable<T> fail(Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.FAIL, throwable.getMessage(), throwable, null);
    }

    @Override
    public <T> DataResultable<T> fail(T data, String message) {
        return new DataResultableImpl<>(ResultStatus.FAIL, message, null, data);
    }

    @Override
    public <T> DataResultable<T> fail(T data, String message, Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.FAIL, message, throwable, data);
    }

    @Override
    public <T> DataResultable<T> fail(String message, Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.FAIL, message != null ? message : throwable.getMessage(), throwable, null);
    }

    @Override
    public <T> DataResultable<T> warning(String message) {
        return new DataResultableImpl<>(ResultStatus.WARNING, message, null, null);
    }

    @Override
    public <T> DataResultable<T> warning(Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.WARNING, throwable.getMessage(), throwable, null);
    }

    @Override
    public <T> DataResultable<T> warning(T data, String message) {
        return new DataResultableImpl<>(ResultStatus.WARNING, message, null, data);
    }

    @Override
    public <T> DataResultable<T> warning(T data, String message, Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.WARNING, message, throwable, data);
    }

    @Override
    public <T> DataResultable<T> warning(String message, Throwable throwable) {
        return new DataResultableImpl<>(ResultStatus.WARNING, message, throwable, null);
    }
}
