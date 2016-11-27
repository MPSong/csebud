package buddy.file;

import org.springframework.web.multipart.MultipartFile;
 
public class FileInfo {
	
    private MultipartFile uploadfile;
 
    public MultipartFile getUploadfile() {
        return uploadfile;
    }
 
    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }
    
}