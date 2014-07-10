import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;

//演習16
public class Es4 extends JFrame{
	
	//只の関数だったorz
	public BranchGroup createSceneGraph(){
		BranchGroup obj = new BranchGroup();
		
		//頂点8つ分
		Point3d[] vertex = new Point3d[8];
		
		vertex[0] = new Point3d(-0.9, 0.0, 0.0);
	    vertex[1] = new Point3d( 0.6, 0.1, 0.4);
        vertex[2] = new Point3d( 0.1, 0.7, 0.2);
        vertex[3] = new Point3d(-0.9, 0.5, 0.0);
        vertex[4] = new Point3d(-0.3, 0.3, -0.5);
        vertex[5] = new Point3d(-0.3,-0.1, 0.5);
        vertex[6] = new Point3d( 0.3,-0.4, 0.7);
        vertex[7] = new Point3d( 0.3, 0.3,  0.5);
		
		//QuadArrayクラスにより形状作成
		QuadArray geometry = 
				new QuadArray( vertex.length, GeometryArray.COORDINATES |
						GeometryArray.COLOR_3 );
		geometry.setCoordinates( 0, vertex );
		
		//頂点色配列
		Color3f[] colors = {
			new Color3f(1.0f, 1.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 0.0f),
            new Color3f(1.0f, 1.0f, 0.0f),
            new Color3f(1.0f, 1.0f, 0.0f),
            new Color3f(1.0f, 0.0f, 1.0f),
            new Color3f(1.0f, 1.0f, 1.0f),
            new Color3f(0.0f, 0.5f, 0.5f),
            new Color3f(0.3f, 1.0f, 0.0f),
		};
		
		//Geometryを元に物体作成
		Shape3D shape = new Shape3D( geometry );
		geometry.setColors(0, colors);
		obj.addChild( shape );
		obj.compile();
		
		return obj;	
	}
	
	public Es4(){
		getContentPane().setLayout( new BorderLayout() );
		
		GraphicsConfiguration cfg = SimpleUniverse.getPreferredConfiguration();
		
		Canvas3D canvas3d = new Canvas3D( cfg );
		getContentPane().add( "Center", canvas3d );
		
		BranchGroup scene = createSceneGraph();
		SimpleUniverse univ = new SimpleUniverse( canvas3d );
		
		univ.getViewingPlatform().setNominalViewingTransform();
		
		univ.addBranchGraph( scene );
	}
	
	public static void main(String args[]){
		Es4 es4 = new Es4();
		
		//サイズ設定
		es4.setBounds( 0, 0, 300, 300 );
		
		//終了処理
		es4.addWindowListener( 
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
			);

		es4.setVisible( true );
	}
}
