package file;

public class FileDTO {

	String FileName;
	String FileRealName;
	int downloadCount;
	
	public FileDTO(){}
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileRealName() {
		return FileRealName;
	}
	public void setFileRealName(String fileRealName) {
		FileRealName = fileRealName;
	}
	
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public FileDTO(String fileName, String fileRealName, int downloadCount) {
		super();
		FileName = fileName;
		FileRealName = fileRealName;
		this.downloadCount = downloadCount;
	}
	
	
	
}
