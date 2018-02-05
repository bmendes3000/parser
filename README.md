# Parser

Spring batch-based design for the processing and blocking of robot access

### Prerequisites
1. Java 7 installed on the machine

2. The project have a dependence with mysql and is requered create database DbParser, folow the code execution:

CREATE USER 'parser-app'@'localhost' IDENTIFIED BY 'parser-app';<br>
GRANT ALL ON DbParser.* TO 'parser-app'@'localhost';<br>

DROP DATABASE IF EXISTS DbParser;<br>
CREATE DATABASE IF NOT EXISTS DbParser;<br>
USE DbParser;<br>
DROP TABLE IF EXISTS TbAccessAddress;<br>

CREATE TABLE IF NOT EXISTS TbAccessAddress ( <br>
  ipAddress varchar(50) NOT NULL,<br>
  dtAccess datetime NOT NULL,<br>
  methodHttp varchar(50) DEFAULT NULL,<br>
  returnCode int(11) DEFAULT NULL,<br>
  localAccess varchar(300) DEFAULT NULL,<br>
  KEY pkTbAccess (ipAddress,dtAccess)<br>
) ENGINE=InnoDB DEFAULT CHARSET=latin1;<br>
DELETE FROM TbAccessAddress;<br>

DROP TABLE IF EXISTS TbBlockedAddress;<br>
CREATE TABLE IF NOT EXISTS TbBlockedAddress (<br>
  dtBlocked datetime NOT NULL,<br>
  addressIp varchar(50) NOT NULL,<br>
  threshold int(11) NOT NULL,<br>
  description varchar(200) NOT NULL,<br>
  KEY pkTbBlockedAddress (dtBlocked,addressIp)<br>
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1;<br>
DELETE FROM TbBlockedAddress;<br>

### Installing

For generate build of the JAR:

mvn clean install 
(check the target folder will have a file named parser.jar)

Develop in eclipse:

mvn clean install eclipse:eclipse

Any doubts, please, call me.

### Running
for execute the tool, run from command line:

 java -cp "parser.jar" com.ef.Parser --accesslog=/path/to/file --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100 


### License

Permission is hereby granted, free of charge, to any person obtaining a copy of this project and associated documentation files (the "Project"), to deal in the Project without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE PROJECT IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE PROJECT OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
