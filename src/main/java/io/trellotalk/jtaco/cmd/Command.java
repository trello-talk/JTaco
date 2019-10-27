package io.trellotalk.jtaco.cmd;

public enum Command {

    /** Used to test server status and latency */
    PING("ping", 0, false),

    BOARDS("boards", 1, false),

    NOT_COMMAND("", 0, false),

    /** Used for unrecognized commands */
    UNKNOWN("", 0, false);

    /**
     * Command prefix to be used to recognize commands.
     * Channel messages that start with this {@code String} will be considered commands
     */
    public static final String PREFIX = "T!";

    final String value;
    final int minParams;
    final boolean caseSens;

    Command(String value, int params, boolean caseSens) {
        this.value = value;
        this.minParams = params;
        this.caseSens = caseSens;
    }

    /**
     * @param command text value to validate
     * @return {@code true} if the text value starts with a standard command {@link #PREFIX}
     */
    public static boolean isValid(String command) {
        return command.length() >= PREFIX.length() && command.substring(0, PREFIX.length()).equals(PREFIX);
    }

    /**
     * Attempt to find the command represented by the given text value.
     *
     * @param command text value that represents the command to find
     * @return {@code Command} instance represented by the given text value or {@link #UNKNOWN}
     *         if no command that matches the text value has been found or it's not a command.
     */
    public static Command find(String command) {

        if (!isValid(command)) {
            return Command.NOT_COMMAND;
        }
        for (Command value : values()) {
            if (value.toString().equals(command.substring(PREFIX.length())))
                return value;
        }
        return Command.UNKNOWN;
    }

    /**
     * @return {@code true} if uppercase and lowercase should be treated as distinct or equivalent
     */
    public boolean isCaseSensitive() {
        return caseSens;
    }
    /**
     * @return text value represented by this command.
     */
    @Override
    public String toString() {
        return value;
    }
}
