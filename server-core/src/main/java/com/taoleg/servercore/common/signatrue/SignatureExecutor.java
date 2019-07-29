package com.taoleg.servercore.common.signatrue;

public interface SignatureExecutor {

    Signature build(Object... o);

    boolean validate(Signature signature, Object... objects);
}
