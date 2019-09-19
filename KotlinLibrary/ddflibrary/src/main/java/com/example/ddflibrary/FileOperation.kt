package com.example.ddflibrary

import java.io.*

class FileOperation {

    companion object ReadFile{

        /**
         * Called when reading data from a text file.
         *
         * @param filePath: The path where the document, to be read, is located.
         *
         * @return A String Object containing the entire document data.
         */
        fun fileRead(filePath: String): String?{

            var line: String?

            try {
                // initializing streamer to read a file
                val fileInputStream = FileInputStream(filePath)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)

                // string builder to concatenate all the lines read
                val stringBuilder = StringBuilder()

                // to read a line
                line = bufferedReader.readLine()

                //to check end of document
                while (line != null) {
                    stringBuilder.append(line + System.getProperty("line.separator"))
                    line = bufferedReader.readLine()
                }

                line = stringBuilder.toString()

                // closing the streamer after use
                fileInputStream.close()
                bufferedReader.close()

            } catch (ex: FileNotFoundException) {           // exception handling for file not found
                throw ex
            } catch (ex: IOException) {                     // exception handling for read operation
                throw ex
            } catch (ex: Exception) {                       // for any other exception
                throw ex
            }

            return line
        }

        /**
         * Called when writing data to a text file.
         *
         * @param folder: The folder path where the document, to be written, should be placed.
         * @param filename: The name of the file, to be written.
         * @param data: The String to be written in the document.
         *
         * @return A Boolean object to specify whether the write operation is successful or not.
         */
        fun fileWrite(folder: String, filename: String, data: String): Boolean{

            try{
                val writeFolderPath = File(folder)

                //check if the folder exist or not
                if (!writeFolderPath.exists()) {
                    // if not, create the directory
                    writeFolderPath.mkdirs()
                }

                val writeFilePath = File("$folder/$filename")
                //check if the file exist or not
                if(!writeFilePath.exists()){
                    // if not, create the file
                    writeFilePath.createNewFile()
                }

                // initializing streamer to write a file
                val fileOutputStream = FileOutputStream(writeFilePath, true)
                fileOutputStream.write((data + System.getProperty("line.separator")).toByteArray())

                // closing the streamer after use
                fileOutputStream.close()

                // return true for successful operation
                return true

            } catch (ex: IOException) {                     // exception handling for write operation
                throw ex
            } catch (ex: Exception) {                       // for any other exception
                throw ex
            }
        }
    }

}