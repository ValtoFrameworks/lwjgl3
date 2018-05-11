/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
#include "common_tools.h"
#include "opengles.h"

typedef void (APIENTRY *glGetPerfMonitorGroupsAMDPROC) (intptr_t, jint, intptr_t);
typedef void (APIENTRY *glGetPerfMonitorCountersAMDPROC) (jint, intptr_t, intptr_t, jint, intptr_t);
typedef void (APIENTRY *glGetPerfMonitorGroupStringAMDPROC) (jint, jint, intptr_t, intptr_t);
typedef void (APIENTRY *glGetPerfMonitorCounterStringAMDPROC) (jint, jint, jint, intptr_t, intptr_t);
typedef void (APIENTRY *glGetPerfMonitorCounterInfoAMDPROC) (jint, jint, jint, intptr_t);
typedef void (APIENTRY *glGenPerfMonitorsAMDPROC) (jint, intptr_t);
typedef void (APIENTRY *glDeletePerfMonitorsAMDPROC) (jint, intptr_t);
typedef void (APIENTRY *glSelectPerfMonitorCountersAMDPROC) (jint, jboolean, jint, jint, intptr_t);
typedef void (APIENTRY *glBeginPerfMonitorAMDPROC) (jint);
typedef void (APIENTRY *glEndPerfMonitorAMDPROC) (jint);
typedef void (APIENTRY *glGetPerfMonitorCounterDataAMDPROC) (jint, jint, jint, intptr_t, intptr_t);

EXTERN_C_ENTER

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorGroupsAMD__JIJ(JNIEnv *__env, jclass clazz, jlong numGroupsAddress, jint groupsSize, jlong groupsAddress) {
    glGetPerfMonitorGroupsAMDPROC glGetPerfMonitorGroupsAMD = (glGetPerfMonitorGroupsAMDPROC)tlsGetFunction(358);
    intptr_t numGroups = (intptr_t)numGroupsAddress;
    intptr_t groups = (intptr_t)groupsAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorGroupsAMD(numGroups, groupsSize, groups);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorCountersAMD__IJJIJ(JNIEnv *__env, jclass clazz, jint group, jlong numCountersAddress, jlong maxActiveCountersAddress, jint counterSize, jlong countersAddress) {
    glGetPerfMonitorCountersAMDPROC glGetPerfMonitorCountersAMD = (glGetPerfMonitorCountersAMDPROC)tlsGetFunction(359);
    intptr_t numCounters = (intptr_t)numCountersAddress;
    intptr_t maxActiveCounters = (intptr_t)maxActiveCountersAddress;
    intptr_t counters = (intptr_t)countersAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorCountersAMD(group, numCounters, maxActiveCounters, counterSize, counters);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorGroupStringAMD__IIJJ(JNIEnv *__env, jclass clazz, jint group, jint bufSize, jlong lengthAddress, jlong groupStringAddress) {
    glGetPerfMonitorGroupStringAMDPROC glGetPerfMonitorGroupStringAMD = (glGetPerfMonitorGroupStringAMDPROC)tlsGetFunction(360);
    intptr_t length = (intptr_t)lengthAddress;
    intptr_t groupString = (intptr_t)groupStringAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorGroupStringAMD(group, bufSize, length, groupString);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorCounterStringAMD__IIIJJ(JNIEnv *__env, jclass clazz, jint group, jint counter, jint bufSize, jlong lengthAddress, jlong counterStringAddress) {
    glGetPerfMonitorCounterStringAMDPROC glGetPerfMonitorCounterStringAMD = (glGetPerfMonitorCounterStringAMDPROC)tlsGetFunction(361);
    intptr_t length = (intptr_t)lengthAddress;
    intptr_t counterString = (intptr_t)counterStringAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, counterString);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorCounterInfoAMD__IIIJ(JNIEnv *__env, jclass clazz, jint group, jint counter, jint pname, jlong dataAddress) {
    glGetPerfMonitorCounterInfoAMDPROC glGetPerfMonitorCounterInfoAMD = (glGetPerfMonitorCounterInfoAMDPROC)tlsGetFunction(362);
    intptr_t data = (intptr_t)dataAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorCounterInfoAMD(group, counter, pname, data);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGenPerfMonitorsAMD__IJ(JNIEnv *__env, jclass clazz, jint n, jlong monitorsAddress) {
    glGenPerfMonitorsAMDPROC glGenPerfMonitorsAMD = (glGenPerfMonitorsAMDPROC)tlsGetFunction(363);
    intptr_t monitors = (intptr_t)monitorsAddress;
    UNUSED_PARAM(clazz)
    glGenPerfMonitorsAMD(n, monitors);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglDeletePerfMonitorsAMD__IJ(JNIEnv *__env, jclass clazz, jint n, jlong monitorsAddress) {
    glDeletePerfMonitorsAMDPROC glDeletePerfMonitorsAMD = (glDeletePerfMonitorsAMDPROC)tlsGetFunction(364);
    intptr_t monitors = (intptr_t)monitorsAddress;
    UNUSED_PARAM(clazz)
    glDeletePerfMonitorsAMD(n, monitors);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglSelectPerfMonitorCountersAMD__IZIIJ(JNIEnv *__env, jclass clazz, jint monitor, jboolean enable, jint group, jint numCounters, jlong counterListAddress) {
    glSelectPerfMonitorCountersAMDPROC glSelectPerfMonitorCountersAMD = (glSelectPerfMonitorCountersAMDPROC)tlsGetFunction(365);
    intptr_t counterList = (intptr_t)counterListAddress;
    UNUSED_PARAM(clazz)
    glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_glBeginPerfMonitorAMD(JNIEnv *__env, jclass clazz, jint monitor) {
    glBeginPerfMonitorAMDPROC glBeginPerfMonitorAMD = (glBeginPerfMonitorAMDPROC)tlsGetFunction(366);
    UNUSED_PARAM(clazz)
    glBeginPerfMonitorAMD(monitor);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_glEndPerfMonitorAMD(JNIEnv *__env, jclass clazz, jint monitor) {
    glEndPerfMonitorAMDPROC glEndPerfMonitorAMD = (glEndPerfMonitorAMDPROC)tlsGetFunction(367);
    UNUSED_PARAM(clazz)
    glEndPerfMonitorAMD(monitor);
}

JNIEXPORT void JNICALL Java_org_lwjgl_opengles_AMDPerformanceMonitor_nglGetPerfMonitorCounterDataAMD__IIIJJ(JNIEnv *__env, jclass clazz, jint monitor, jint pname, jint dataSize, jlong dataAddress, jlong bytesWrittenAddress) {
    glGetPerfMonitorCounterDataAMDPROC glGetPerfMonitorCounterDataAMD = (glGetPerfMonitorCounterDataAMDPROC)tlsGetFunction(368);
    intptr_t data = (intptr_t)dataAddress;
    intptr_t bytesWritten = (intptr_t)bytesWrittenAddress;
    UNUSED_PARAM(clazz)
    glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, bytesWritten);
}

EXTERN_C_EXIT
