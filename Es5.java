import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.behaviors.mouse.*;

//�ۑ�
public class Es5 extends JFrame{
	
	//�i�ߓ�
	public Es5(){
		getContentPane().setLayout( new BorderLayout() );
		
		//�n�[�h�E�F�A���Ɋ�Â��Đݒ���s��
		GraphicsConfiguration cfg = SimpleUniverse.getPreferredConfiguration();
		
		//3D�`��̈�
		//ContentPane��Jframe�̕\���̈�̂���
		Canvas3D canvas3d = new Canvas3D( cfg );
		getContentPane().add( "Center", canvas3d );
		

		//���z���:�J���������ݒu
		SimpleUniverse univ = new SimpleUniverse( canvas3d );
		univ.getViewingPlatform().setNominalViewingTransform();
		
		//--------�v���~�e�B�u�����ēo�^����--------
		BranchGroup Pri = construct();
//		BranchGroup zuK = construct();
		
		//TransformGroup�p��
		TransformGroup tg = new TransformGroup();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);		
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		//�}�E�X�]�X�BBoundingSphere�ɂ����ƁB
		BoundingSphere bs = new BoundingSphere( new Point3d(), 10.0);
		
		MouseRotate rotM = new MouseRotate( tg );
		rotM.setSchedulingBounds( bs );
		Pri.addChild( rotM );
		
		MouseTranslate tranM = new MouseTranslate( tg );
		tranM.setSchedulingBounds( bs );
		Pri.addChild( tranM );
		
		MouseZoom zoomM = new MouseZoom( tg );
		zoomM.setSchedulingBounds( bs );
		Pri.addChild( zoomM );
		
		//TransformGroup��BranchGroup�֓o�^
//		tg.addChild(zuK);
		Pri.addChild(tg);

		univ.addBranchGraph( Pri );
	}
	
	//�g����
	BranchGroup construct(){
		BranchGroup bg = new BranchGroup();
		
		//Appearance�ݒ�
		Appearance app = new Appearance();
		app.setColoringAttributes(
                new ColoringAttributes(1.0f, 1.0f, 1.0f, ColoringAttributes.FASTEST));
		
		//Transform3D,TransformGroup��������Ċe�ʐ}�`�o�^�B
		
		
		//TransformGroup�o�^
		for(int i=0; i<mt.length; i++){
			if(mt[i] == null){break;}
			bg.addChild(mt[i]);
		}
		bg.compile();
		return bg;
	}
	
	//�|���S���BBG������ēo�^���ĕԂ��B
	BranchGroup polyTriPole( BranchGroup bg, int len ){
		
		
		return bg;
	}
	
	
	
	//�E�B���h�E
	public static void main(String args[]){
		Es5 es5 = new Es5();
		
		//�T�C�Y�ݒ�
		es5.setBounds( 0, 0, 600, 600 );
		
		//�I������
		es5.addWindowListener( 
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
			);

		es5.setVisible( true );
	}
}
