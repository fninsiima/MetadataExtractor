/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappserver;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;



import java.io.File;

/**
 *
 * @author Delmira
 */
public class MetadataExtractor {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        String filename = "C:\\1.jpg";
        try
        {
            File jpgFile = new File( filename );
            Metadata metadata = JpegMetadataReader.readMetadata(jpgFile);

            GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            if(gpsDirectory != null)
            {
                GeoLocation location = gpsDirectory.getGeoLocation();
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                System.out.println("Latitude: " + lat);
                System.out.println("Longitude : " + lng);
            }
            else
            {
                System.out.println( "EXIF is null" );
            }
        
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
                
    }
    
}
