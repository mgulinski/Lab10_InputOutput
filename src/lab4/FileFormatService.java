/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Machi
 */
public class FileFormatService {

    private FileDecodingStrategy decoder;
    private TextEncodingStrategy encoder;

    public FileFormatService(FileDecodingStrategy decoder,
	    TextEncodingStrategy encoder) {
	this.decoder = decoder;
	this.encoder = encoder;
    }

    public List< LinkedHashMap<String, String>> decodeFileData(List<String> inputDataLines) {
	return decoder.decodeData(inputDataLines);
    }

    public List<String> encodeFileData(List< LinkedHashMap<String, String>> decodedRecordList) {
	return encoder.encodeData(decodedRecordList);

    }
}
