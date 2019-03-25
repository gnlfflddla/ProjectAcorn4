package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dto.ProductDTO;
import com.service.ProductService;


@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		//파일 크기
		// b -> kb -> mb -> Gb 
		upload.setFileSizeMax(1024*1024); // 개별 파일최대 크기 1024*1024 -> 1mb
		upload.setSizeMax(1024*1024*5); // 총 파일 크기 .. 1024*1024*5 -> 5mb
		
			
		//Create a progress listener
		ProgressListener progressListener = new ProgressListener(){
		   public void update(long pBytesRead, long pContentLength, int pItems) {
		      // System.out.println("We are currently reading item " + pItems);
		       if (pContentLength == -1) {
		         //  System.out.println("So far, " + pBytesRead + " bytes have been read.");
		       } else {
/*		          System.out.println("So far, " + pBytesRead + " of " + pContentLength
		                              + " bytes have been read.");*/
		       }
		   }
		};
		
		upload.setProgressListener(progressListener);
		

		// Parse the request .. 업로드된 파일 정보 ( 여러개의 파일 업로드 가능 )
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		
		String fileName="";
		String pCode=null;
		String pName=null;
		String pContent=null;
		String pCategory=null;
		String pPrice=null;	
		ArrayList<String> pImage = new ArrayList<>();
		ArrayList<String> pColor = new ArrayList<>();
		ArrayList<String> pSize = new ArrayList<>();

	    
		while (iter.hasNext()) {
		    FileItem item = iter.next();
		    if (item.isFormField()) {
		    	// type="file"이 아닌 처리
		        String name = item.getFieldName();
		        String value = item.getString("UTF-8");
		        if(name.equals("pCode")) {
		        	pCode=value;
		        }
		        else if(name.equals("pName")) {
		        	pName=value;
		        }
		        else if(name.equals("pContent")) {
		        	pContent=value;
		        }
		        else if(name.equals("pCategory")) {
		        	pCategory=value;
		        }
		        else if(name.equals("pPrice")) {
		        	pPrice=value;
		        }
		        else if(name.equals("pColor")){
		        	pColor.add(value);
		        }
		        else if(name.equals("pSize")) {
		        	pSize.add(value);
		        }
		    } else {
		    	// type="file"이 파일 처리
		    	fileName = item.getName(); // 파일명
		    	pImage.add(fileName);
		    	File f = new File("c:\\upload", fileName);
		    	try {
					item.write(f);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}//end while

		// 이미지 문자열로 변환
		String pImage2 = "";
		for(int i=0; i<pImage.size(); i++) {
			if(i!=0&&i<pImage.size()) {
				pImage2+=",";
			}
			pImage2 += pImage.get(i);
		}
		
/*			
		// 색상 문자열로 변환
		String pColor2 = "";
		for(int i=0; i<pColor.size(); i++) {
			if(i!=0&&i<pColor.size()) {
				pColor2+=",";
			}
			pColor2 += pColor.get(i);
		}
		
		// 사이즈 문자열로 변환
		String pSize2 = "";
		for(int i=0; i<pSize.size(); i++) {
			if(i!=0&&i<pSize.size()) {
				pSize2+=",";
			}
			pSize2 += pSize.get(i);
		}*/
		
		
	    ProductDTO dto = new ProductDTO();
	    dto.setpCode(pCode);
	    dto.setpName(pName);
	    dto.setpContent(pContent);
	    dto.setpCategory(pCategory);
	    dto.setpPrice(Integer.parseInt(pPrice));
	    dto.setpImage(pImage2);
	    
	    dto.setpColor(pColor);
	    dto.setpSize(pSize);
	    
	    System.out.println(dto);
	    ProductService service = new ProductService();    
	    int n = service.ProductAdd(dto);

	    response.sendRedirect("MainServlet");
	
	}

}
