/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package opengles.templates

import org.lwjgl.generator.*
import opengles.*

val KHR_debug = "KHRDebug".nativeClassGLES("KHR_debug", postfix = KHR) {
    documentation =
        """
        Native bindings to the $registryLink extension.

        This extension allows the GL to notify applications when various events occur that may be useful during application development, debugging and
        profiling.

        These events are represented in the form of enumerable messages with a human-readable string representation. Examples of debug events include incorrect
        use of the GL, warnings of undefined behavior, and performance warnings.

        A message is uniquely identified by a source, a type and an implementation-dependent ID within the source and type pair.

        A message's source identifies the origin of the message and can either describe components of the GL, the window system, third-party external sources
        such as external debuggers, or even the application itself.

        The type of the message roughly identifies the nature of the event that caused the message. Examples include errors, performance warnings, warnings
        about undefined behavior or notifications identifying that the application is within a specific section of the application code.

        A message's ID for a given source and type further distinguishes messages within namespaces. For example, an error caused by a negative parameter value
        or an invalid internal texture format are both errors generated by the API, but would likely have different message IDs.

        Each message is also assigned to a severity level that denotes roughly how "important" that message is in comparison to other messages across all
        sources and types. For example, notification of a GL error would likely have a higher severity than a performance warning due to redundant state changes.

        Furthermore, every message contains an implementation-dependent string representation that provides a useful description of the event.

        Messages are communicated to the application through an application-defined callback function that is called by the GL implementation on each debug
        message. The motivation for the callback routine is to free application developers from actively having to query whether a GL error, or any other
        debuggable event has happened after each call to a GL function. With a callback, developers can keep their code free of debug checks, set breakpoints in
        the callback function, and only have to react to messages as they occur. In situations where using a callback is not possible, a message log is also
        provided that stores only copies of recent messages until they are actively queried.

        To control the volume of debug output, messages can be disabled either individually by ID, or entire sets of messages can be turned off based on
        combination of source and type, through the entire application code or only section of the code encapsulated in debug groups. A debug group may also be
        used to annotate the command stream using descriptive texts.

        This extension also defines debug markers, a mechanism for the OpenGL application to annotate the command stream with markers for discrete events.

        When profiling or debugging an OpenGL application with a built-in or an external debugger or profiler, it is difficult to relate the commands within the
        command stream to the elements of the scene or parts of the program code to which they correspond. Debug markers and debug groups help obviate this by
        allowing applications to specify this link. For example, a debug marker can be used to identify the beginning of a frame in the command stream and a
        debug group can encapsulate a specific command stream to identify a rendering pass. Debug groups also allow control of the debug outputs volume per
        section of an application code providing an effective way to handle the massive amount of debug outputs that drivers can generate.

        Some existing implementations of ARB_debug_output only expose the ARB_debug_output extension string if the context was created with the debug
        flag {GLX|WGL}_CONTEXT_DEBUG_BIT_ARB as specified in {GLX|WGL}_ARB_create_context. The behavior is not obvious when the functionality is brought into
        the OpenGL core specification because the extension string and function entry points must always exist.

        This extension modifies the existing ARB_debug_output extension to allow implementations to always have an empty message log. The specific messages
        written to the message log or callback routines are already implementation defined, so this specification simply makes it explicit that it's fine for
        there to be zero messages generated, even when a GL error occurs, which is useful if the context is non-debug.

        Debug output can be enabled and disabled by changing the #DEBUG_OUTPUT_KHR state.

        Finally, this extension defines a mechanism for OpenGL applications to label their objects (textures, buffers, shaders, etc.) with a descriptive string.

        When profiling or debugging an OpenGL application within an external or built-in (debut output API) debugger or profiler it is difficult to identify
        objects from their object names (integers).

        Even when the object itself is viewed it can be problematic to differentiate between similar objects. Attaching a descriptive string, a label, to an
        object obviates this difficulty.

        The intended purpose of this extension is purely to improve the user experience within OpenGL development tools and application built-in profilers and
        debuggers. This extension typically improves OpenGL programmers efficiency by allowing them to instantly detect issues and the reason for these issues
        giving him more time to focus on adding new features to an OpenGL application.
        """

    IntConstant(
        "Tokens accepted by the {@code target} parameters of Enable, Disable, and  IsEnabled.",

        "DEBUG_OUTPUT_KHR"..0x92E0,
        "DEBUG_OUTPUT_SYNCHRONOUS_KHR"..0x8242
    )

    IntConstant(
        "Returned by GetIntegerv when {@code pname} is CONTEXT_FLAGS.",

        "CONTEXT_FLAG_DEBUG_BIT_KHR"..0x00000002
    )

    IntConstant(
        "Tokens accepted by the {@code value} parameters of GetBooleanv, GetIntegerv,  GetFloatv, GetDoublev and GetInteger64v.",

        "MAX_DEBUG_MESSAGE_LENGTH_KHR"..0x9143,
        "MAX_DEBUG_LOGGED_MESSAGES_KHR"..0x9144,
        "DEBUG_LOGGED_MESSAGES_KHR"..0x9145,
        "DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_KHR"..0x8243,
        "MAX_DEBUG_GROUP_STACK_DEPTH_KHR"..0x826C,
        "DEBUG_GROUP_STACK_DEPTH_KHR"..0x826D,
        "MAX_LABEL_LENGTH_KHR"..0x82E8
    )

    IntConstant(
        "Tokens accepted by the {@code pname} parameter of GetPointerv.",

        "DEBUG_CALLBACK_FUNCTION_KHR"..0x8244,
        "DEBUG_CALLBACK_USER_PARAM_KHR"..0x8245
    )

    val DebugSources = IntConstant(
        """
        Tokens accepted or provided by the {@code source} parameters of DebugMessageControl, DebugMessageInsert and DEBUGPROC, and the {@code sources} parameter
        of GetDebugMessageLog.
        """,

        "DEBUG_SOURCE_API_KHR"..0x8246,
        "DEBUG_SOURCE_WINDOW_SYSTEM_KHR"..0x8247,
        "DEBUG_SOURCE_SHADER_COMPILER_KHR"..0x8248,
        "DEBUG_SOURCE_THIRD_PARTY_KHR"..0x8249,
        "DEBUG_SOURCE_APPLICATION_KHR"..0x824A,
        "DEBUG_SOURCE_OTHER_KHR"..0x824B
    ).javaDocLinks

    val DebugTypes = IntConstant(
        """
        Tokens accepted or provided by the {@code type} parameters of DebugMessageControl, DebugMessageInsert and DEBUGPROC, and the {@code types} parameter of
        GetDebugMessageLog.
        """,

        "DEBUG_TYPE_ERROR_KHR"..0x824C,
        "DEBUG_TYPE_DEPRECATED_BEHAVIOR_KHR"..0x824D,
        "DEBUG_TYPE_UNDEFINED_BEHAVIOR_KHR"..0x824E,
        "DEBUG_TYPE_PORTABILITY_KHR"..0x824F,
        "DEBUG_TYPE_PERFORMANCE_KHR"..0x8250,
        "DEBUG_TYPE_OTHER_KHR"..0x8251,
        "DEBUG_TYPE_MARKER_KHR"..0x8268
    ).javaDocLinks

    IntConstant(
        """
        Tokens accepted or provided by the {@code type} parameters of DebugMessageControl and DEBUGPROC, and the {@code types} parameter of GetDebugMessageLog.
        """,

        "DEBUG_TYPE_PUSH_GROUP_KHR"..0x8269,
        "DEBUG_TYPE_POP_GROUP_KHR"..0x826A
    )

    val DebugSeverities = IntConstant(
        """
        Tokens accepted or provided by the {@code severity} parameters of DebugMessageControl, DebugMessageInsert and DEBUGPROC callback functions, and the
        {@code severities} parameter of GetDebugMessageLog.
        """,

        "DEBUG_SEVERITY_HIGH_KHR"..0x9146,
        "DEBUG_SEVERITY_MEDIUM_KHR"..0x9147,
        "DEBUG_SEVERITY_LOW_KHR"..0x9148,
        "DEBUG_SEVERITY_NOTIFICATION_KHR"..0x826B
    ).javaDocLinks

    IntConstant(
        "Returned by GetError.",

        "STACK_UNDERFLOW_KHR"..0x0504,
        "STACK_OVERFLOW_KHR"..0x0503
    )

    val DebugIdentifiers = IntConstant(
        "Tokens accepted or provided by the {@code identifier} parameters of ObjectLabel and GetObjectLabel.",

        "BUFFER_KHR"..0x82E0,
        "SHADER_KHR"..0x82E1,
        "PROGRAM_KHR"..0x82E2,
        "QUERY_KHR"..0x82E3,
        "PROGRAM_PIPELINE_KHR"..0x82E4,
        "SAMPLER_KHR"..0x82E6
    ).javaDocLinks

    void(
        "DebugMessageControlKHR",
        """
        Controls the volume of debug output in the active debug group, by disabling specific or groups of messages.

        If {@code enabled} is #TRUE, the referenced subset of messages will be enabled. If #FALSE, then those messages will be disabled.

        This command can reference different subsets of messages by first considering the set of all messages, and filtering out messages based on the following
        ways:
        ${ul(
            """
            If {@code source}, {@code type}, or {@code severity} is #DONT_CARE, the messages from all sources, of all types, or of all severities are
            referenced respectively.
            """,
            """
            When values other than #DONT_CARE are specified, all messages whose source, type, or severity match the specified {@code source}, {@code type},
            or {@code severity} respectively will be referenced.
            """,
            """
            If {@code count} is greater than zero, then {@code ids} is an array of {@code count} message IDs for the specified combination of {@code source} and
            {@code type}. In this case, if {@code source} or {@code type} is #DONT_CARE, or {@code severity} is not #DONT_CARE, the error
            #INVALID_OPERATION is generated.
            """
        )}
        Unrecognized message IDs in {@code ids} are ignored. If {@code count} is zero, the value if {@code ids} is ignored.

        Although messages are grouped into an implicit hierarchy by their sources and types, there is no explicit per-source, per-type or per-severity enabled
        state. Instead, the enabled state is stored individually for each message. There is no difference between disabling all messages from one source in a
        single call, and individually disabling all messages from that source using their types and IDs.

        If the #DEBUG_OUTPUT_KHR state is disabled the GL operates the same as if messages of every {@code source}, {@code type} or {@code severity} are
        disabled.
        """,

        GLenum.IN("source", "the source of debug messages to enable or disable", DebugSources),
        GLenum.IN("type", "the type of debug messages to enable or disable", DebugTypes),
        GLenum.IN("severity", "the severity of debug messages to enable or disable", DebugSeverities),
        AutoSize("ids")..GLsizei.IN("count", "the length of the array {@code ids}"),
        SingleValue("id")..nullable..GLuint.const.p.IN("ids", "an array of unsigned integers containing the ids of the messages to enable or disable"),
        GLboolean.IN("enabled", "whether the selected messages should be enabled or disabled")
    )

    void(
        "DebugMessageInsertKHR",
        """
        This function can be called by applications and third-party libraries to generate their own messages, such as ones containing timestamp information or
        signals about specific render system events.

        The value of {@code id} specifies the ID for the message and {@code severity} indicates its severity level as defined by the caller. The string
        {@code buf} contains the string representation of the message. The parameter {@code length} contains the number of characters in {@code buf}. If
        {@code length} is negative, it is implied that {@code buf} contains a null terminated string. The error #INVALID_VALUE will be generated if the
        number of characters in {@code buf}, excluding the null terminator when {@code length} is negative, is not less than the value of
        #MAX_DEBUG_MESSAGE_LENGTH_KHR.

        If the #DEBUG_OUTPUT_KHR state is disabled calls to DebugMessageInsert are discarded and do not generate an error.
        """,

        GLenum.IN("source", "the source of the debug message to insert", DebugSources),
        GLenum.IN("type", "the type of the debug message insert", DebugTypes),
        GLuint.IN("id", "the user-supplied identifier of the message to insert", DebugSeverities),
        GLenum.IN("severity", "the severity of the debug messages to insert"),
        AutoSize("message")..GLsizei.IN("length", "the length of the string contained in the character array whose address is given by {@code message}"),
        GLcharUTF8.const.p.IN("message", "a character array containing the message to insert")
    )

    void(
        "DebugMessageCallbackKHR",
        """
        Specifies a callback to receive debugging messages from the GL.

        The function's prototype must follow the type definition of DEBUGPROC including its platform-dependent calling convention. Anything else will result in
        undefined behavior. Only one debug callback can be specified for the current context, and further calls overwrite the previous callback. Specifying
        #NULL as the value of {@code callback} clears the current callback and disables message output through callbacks. Applications can provide
        user-specified data through the pointer {@code userParam}. The context will store this pointer and will include it as one of the parameters in each call
        to the callback function.

        If the application has specified a callback function for receiving debug output, the implementation will call that function whenever any enabled message
        is generated.  The source, type, ID, and severity of the message are specified by the DEBUGPROC parameters {@code source}, {@code type}, {@code id}, and
        {@code severity}, respectively. The string representation of the message is stored in {@code message} and its length (excluding the null-terminator) is
        stored in {@code length}. The parameter {@code userParam} is the user-specified parameter that was given when calling DebugMessageCallback.

        Applications can query the current callback function and the current user-specified parameter by obtaining the values of #DEBUG_CALLBACK_FUNCTION_KHR
        and #DEBUG_CALLBACK_USER_PARAM_KHR, respectively.

        Applications that specify a callback function must be aware of certain special conditions when executing code inside a callback when it is called by the
        GL, regardless of the debug source.

        The memory for {@code message} is owned and managed by the GL, and should only be considered valid for the duration of the function call.

        The behavior of calling any GL or window system function from within the callback function is undefined and may lead to program termination.

        Care must also be taken in securing debug callbacks for use with asynchronous debug output by multi-threaded GL implementations.

        If the #DEBUG_OUTPUT_KHR state is disabled then the GL will not call the callback function.
        """,

        nullable..GLDEBUGPROCKHR.IN("callback", "a callback function that will be called when a debug message is generated"),
        nullable..opaque_const_p.IN(
            "userParam",
            "a user supplied pointer that will be passed on each invocation of {@code callback}"
        )
    )

    GLuint(
        "GetDebugMessageLogKHR",
        """
        Retrieves messages from the debug message log.

        This function fetches a maximum of {@code count} messages from the message log, and will return the number of messages successfully fetched.

        Messages will be fetched from the log in order of oldest to newest. Those messages that were fetched will be removed from the log.

        The sources, types, severities, IDs, and string lengths of fetched messages will be stored in the application-provided arrays {@code sources},
        {@code types}, {@code severities}, {@code ids}, and {@code lengths}, respectively. The application is responsible for allocating enough space for each
        array to hold up to {@code count} elements. The string representations of all fetched messages are stored in the {@code messageLog} array. If multiple
        messages are fetched, their strings are concatenated into the same {@code messageLog} array and will be separated by single null terminators. The last
        string in the array will also be null-terminated. The maximum size of {@code messageLog}, including the space used by all null terminators, is given by
        {@code bufSize}. If {@code bufSize} is less than zero and {@code messageLog} is not #NULL, an #INVALID_VALUE error will be generated. If a message's
        string, including its null terminator, can not fully fit within the {@code messageLog} array's remaining space, then that message and any subsequent
        messages will not be fetched and will remain in the log. The string lengths stored in the array {@code lengths} include the space for the null terminator of each string.

        Any or all of the arrays {@code sources}, {@code types}, {@code ids}, {@code severities}, {@code lengths} and {@code messageLog} can also be null
        pointers, which causes the attributes for such arrays to be discarded when messages are fetched, however those messages will still be removed from the
        log. Thus to simply delete up to {@code count} messages from the message log while ignoring their attributes, the application can call the function with
        null pointers for all attribute arrays.

        If the context was created without the #CONTEXT_FLAG_DEBUG_BIT_KHR, then the GL can opt to never add messages to the message log so GetDebugMessageLog will
        always return zero.
        """,

        GLuint.IN("count", "the number of debug messages to retrieve from the log"),
        AutoSize("messageLog")..GLsizei.IN("bufsize", "the size of the buffer whose address is given by {@code messageLog}"),
        Check("count")..nullable..GLenum.p.OUT("sources", "an array of variables to receive the sources of the retrieved messages"),
        Check("count")..nullable..GLenum.p.OUT("types", "an array of variables to receive the types of the retrieved messages"),
        Check("count")..nullable..GLuint.p.OUT("ids", "an array of unsigned integers to receive the ids of the retrieved messages"),
        Check("count")..nullable..GLenum.p.OUT("severities", "an array of variables to receive the severites of the retrieved messages"),
        Check("count")..nullable..GLsizei.p.OUT("lengths", "an array of variables to receive the lengths of the received messages"),
        nullable..GLcharUTF8.p.OUT("messageLog", "an array of characters that will receive the messages")
    )

    void(
        "GetPointervKHR",
        "",

        GLenum.IN("pname", ""),
        ReturnParam..Check(1)..void.p.p.OUT("params", "")
    )

    void(
        "PushDebugGroupKHR",
        """
        Pushes a debug group described by the string {@code message} into the command stream. The value of {@code id} specifies the ID of messages generated.
        The parameter {@code length} contains the number of characters in {@code message}. If {@code length} is negative, it is implied that {@code message}
        contains a null terminated string. The message has the specified {@code source} and {@code id}, {@code type} #DEBUG_TYPE_PUSH_GROUP_KHR, and
        {@code severity} #DEBUG_SEVERITY_NOTIFICATION_KHR. The GL will put a new debug group on top of the debug group stack which inherits the control of the
        volume of debug output of the debug group previously residing on the top of the debug group stack. Because debug groups are strictly hierarchical, any
        additional control of the debug output volume will only apply within the active debug group and the debug groups pushed on top of the active debug
        group.

        An #INVALID_ENUM error is generated if the value of {@code source} is neither #DEBUG_SOURCE_APPLICATION_KHR nor #DEBUG_SOURCE_THIRD_PARTY_KHR. An
        #INVALID_VALUE error is generated if {@code length} is negative and the number of characters in {@code message}, excluding the null-terminator,
        is not less than the value of #MAX_DEBUG_MESSAGE_LENGTH_KHR.
        """,

        GLenum.IN("source", "the source of the debug message", "#DEBUG_SOURCE_APPLICATION_KHR #DEBUG_SOURCE_THIRD_PARTY_KHR"),
        GLuint.IN("id", "the identifier of the message"),
        AutoSize("message")..GLsizei.IN("length", "the length of the message to be sent to the debug output stream"),
        GLcharUTF8.const.p.IN("message", "a string containing the message to be sent to the debug output stream")
    )

    void(
        "PopDebugGroupKHR",
        """
        Pops the active debug group. When a debug group is popped, the GL will also generate a debug output message describing its cause based on the
        {@code message} string, the source {@code source}, and an ID {@code id} submitted to the associated #PushDebugGroupKHR() command.
        #DEBUG_TYPE_PUSH_GROUP_KHR and #DEBUG_TYPE_POP_GROUP_KHR share a single namespace for message {@code id}. {@code severity} has the value
        #DEBUG_SEVERITY_NOTIFICATION_KHR. The {@code type} has the value #DEBUG_TYPE_POP_GROUP_KHR. Popping a debug group restores the debug output volume
        control of the parent debug group.

        Attempting to pop the default debug group off the stack generates a #STACK_UNDERFLOW_KHR error; pushing a debug group onto a stack containing
        #MAX_DEBUG_GROUP_STACK_DEPTH_KHR minus one elements will generate a #STACK_OVERFLOW_KHR error.
        """
    )

    void(
        "ObjectLabelKHR",
        "Labels a named object identified within a namespace.",

        GLenum.IN(
            "identifier",
            "the namespace from which the name of the object is allocated",
            DebugIdentifiers + " #TEXTURE #RENDERBUFFER #FRAMEBUFFER #TRANSFORM_FEEDBACK"
        ),
        GLuint.IN("name", "the name of the object to label"),
        AutoSize("label")..GLsizei.IN("length", "the length of the label to be used for the object"),
        GLcharUTF8.const.p.IN("label", "a string containing the label to assign to the object")
    )

    void(
        "GetObjectLabelKHR",
        "Retrieves the label of a named object identified within a namespace.",

        GLenum.IN(
            "identifier",
            "the namespace from which the name of the object is allocated",
            DebugIdentifiers + " #TEXTURE #RENDERBUFFER #FRAMEBUFFER #TRANSFORM_FEEDBACK"
        ),
        GLuint.IN("name", "the name of the object whose label to retrieve"),
        AutoSize("label")..GLsizei.IN("bufSize", "the length of the buffer whose address is in {@code label}"),
        Check(1)..nullable..GLsizei.p.OUT("length", "the address of a variable to receive the length of the object label"),
        Return("length", "GLES20.glGetInteger(GL_MAX_LABEL_LENGTH_KHR)")..GLcharUTF8.p.OUT("label", "a string that will receive the object label")
    )

    void(
        "ObjectPtrLabelKHR",
        "Labels a sync object identified by a pointer.",

        opaque_p.IN("ptr", "a pointer identifying a sync object"),
        AutoSize("label")..GLsizei.IN("length", "the length of the label to be used for the object"),
        GLcharUTF8.const.p.IN("label", "a string containing the label to assign to the object")
    )

    void(
        "GetObjectPtrLabelKHR",
        "Retrieves the label of a sync object identified by a pointer.",

        opaque_p.IN("ptr", "the name of the sync object whose label to retrieve"),
        AutoSize("label")..GLsizei.IN("bufSize", "the length of the buffer whose address is in {@code label}"),
        Check(1)..nullable..GLsizei.p.OUT("length", "a variable to receive the length of the object label"),
        Return("length", "GLES20.glGetInteger(GL_MAX_LABEL_LENGTH_KHR)")..GLcharUTF8.p.OUT("label", "a string that will receive the object label")
    )
}