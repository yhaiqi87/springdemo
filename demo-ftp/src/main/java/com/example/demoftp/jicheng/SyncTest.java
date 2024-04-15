package com.example.demoftp.jicheng;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/10/7 16:21
 */
public class SyncTest extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }
}
