import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;

//���K16
public class Es4 extends JFrame{
	
	//���̊֐�������orz
	public BranchGroup createSceneGraph(){
		BranchGroup obj = new BranchGroup();
		
		//���_8��
		Point3d[] vertex = new Point3d[8];
		
		vertex[0] = new Point3d(-0.9, 0.0, 0.0);
	    vertex[1] = new Point3d( 0.6, 0.1, 0.4);
        vertex[2] = new Point3d( 0.1, 0.7, 0.2);
        vertex[3] = new Point3d(-0.9, 0.5, 0.0);
        vertex[4] = new Point3d(-0.3, 0.3, -0.5);
        vertex[5] = new Point3d(-0.3,-0.1, 0.5);
        vertex[6] = new Point3d( 0.3,-0.4, 0.7);
        vertex[7] = new Point3d( 0.3, 0.3,  0.5);
		
		//QuadArray�N���X�ɂ��`��쐬
		QuadArray geometry = 
				new QuadArray( vertex.length, GeometryArray.COORDINATES |
						GeometryArray.COLOR_3 );
		geometry.setCoordinates( 0, vertex );
		
		//���_�F�z��
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
		
		//Geometry�����ɕ��̍쐬
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
		
		//�T�C�Y�ݒ�
		es4.setBounds( 0, 0, 300, 300 );
		
		//�I������
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
