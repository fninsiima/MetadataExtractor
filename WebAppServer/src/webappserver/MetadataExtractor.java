/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappserver;

import com.drew.imaging.ImageMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.drew.metadata.exif.GpsDescriptor;


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
      
        String filename = "C:\\negative288.jpg";
        try
        {
            File jpgFile = new File( filename );
            Metadata metadata = ImageMetadataReader.readMetadata(jpgFile);

            GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);
            GpsDescriptor gpsDesc = new GpsDescriptor(gpsDirectory);
            
            if(gpsDirectory != null)
            {
                GeoLocation location = gpsDirectory.getGeoLocation();
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                System.out.println("Latitude: " + lat);
                System.out.println("Longitude : " + lng);
                System.out.println("Altitude : " + gpsDesc.getGpsAltitudeDescription());
                System.out.println("GpsTimeStamp : " + gpsDesc.getGpsTimeStampDescription());
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
