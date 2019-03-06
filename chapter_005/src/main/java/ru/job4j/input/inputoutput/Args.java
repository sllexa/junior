package ru.job4j.input.inputoutput;

import java.util.Arrays;
import java.util.List;

/**
 * Class Args.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 27.02.2019
 */
public class Args {
    /**
     * Array of arguments.
     */
    private String[] args;
    /**
     * Argument directory.
     */
    private String dir = "-d";
    /**
     * Argument extensions.
     */
    private String exts = "-e";
    /**
     * Argument output file.
     */
    private String out = "-o";

    /**
     * Constructor.
     * @param args - arguments
     */
    public Args(String[] args) {
        this.args = args;
    }

    /**
     * Method argument parse.
     * @param parameter -
     * @return string
     */
    private String parseArguments(String parameter) {
        String result = "";
        for (int i = 0; i <  args.length; i++) {
            if (args[i].equals(parameter)) {
                while (i < args.length - 1) {
                    result = result + args[++i] + " ";
                    if (i + 1 == args.length ||  args[i + 1].contains("-")) {
                        break;
                    }
                }
                break;
            }
        }
        return result.trim();
    }

    /**
     * Method directory.
     * @return string
     */
    public String directory() {
        return parseArguments(this.dir);
    }

    /**
     * Method exclude.
     * @return list string
     */
    public List<String> exclude() {
        String result = parseArguments(this.exts);
        return Arrays.asList(result.split(" "));
    }

    /**
     * Method output.
     * @return string
     */
    public String output() {
        return parseArguments(this.out);
    }
}
