/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embedmongo.config;

import de.flapdoodle.embedmongo.io.IStreamProcessor;
import de.flapdoodle.embedmongo.io.Processors;

public class MongodProcessOutputConfig {

    private final IStreamProcessor _mongodOutput;
    private final IStreamProcessor _mongodError;
    private final IStreamProcessor _commandsOutput;

    public MongodProcessOutputConfig(IStreamProcessor mongodOutput, IStreamProcessor mongodError,
                                     IStreamProcessor commandsOutput) {
        _mongodOutput = mongodOutput;
        _mongodError = mongodError;
        _commandsOutput = commandsOutput;
    }

    public IStreamProcessor getMongodOutput() {
        return _mongodOutput;
    }

    public IStreamProcessor getMongodError() {
        return _mongodError;
    }

    public IStreamProcessor getCommandsOutput() {
        return _commandsOutput;
    }

    public static MongodProcessOutputConfig getDefaultInstance() {
        return new MongodProcessOutputConfig(Processors.namedConsole("[mongod output]"),
                Processors.namedConsole("[mongod error]"), Processors.console());
    }
}
