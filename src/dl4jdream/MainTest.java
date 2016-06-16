/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dl4jdream;

import java.io.IOException;
import org.deeplearning4j.caffe.common.CaffeLoader;
import org.deeplearning4j.caffe.common.NNConfigBuilderContainer;
import org.deeplearning4j.caffe.common.SolverNetContainer;
import org.deeplearning4j.caffe.create.DL4jCaffeNetCreator;
import org.deeplearning4j.caffe.dag.CaffeNode;
import org.deeplearning4j.caffe.dag.Graph;
import org.deeplearning4j.caffe.proto.Caffe;
import org.deeplearning4j.caffe.translate.CaffeLayerGraphConversion;
import org.deeplearning4j.caffe.translate.CaffeNetTranslator;
import org.deeplearning4j.caffe.translate.CaffeSolverTranslator;
import org.deeplearning4j.nn.api.Layer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
/**
 *
 * @author psyriccio
 */
public class MainTest {

  public static void prn(String msg) {
    System.out.println(msg);
  }
  
  public void doTest() throws IOException, IllegalAccessException, NoSuchFieldException, Exception {

    CaffeLoader cfLoader = new CaffeLoader();
    cfLoader.binaryNet("./model/bvlc_googlenet.caffemodel")
            .textFormatSolver("./model/solver.prototxt");
    
    SolverNetContainer slNetCont = cfLoader.load();

    CaffeNetTranslator netTranslator = new CaffeNetTranslator();
    CaffeSolverTranslator solverTranslator = new CaffeSolverTranslator();

    Caffe.SolverParameter solver = slNetCont.getSolver();
    Caffe.NetParameter net = slNetCont.getNet();    
    
    NNConfigBuilderContainer nnConfigBuilderContainer = new NNConfigBuilderContainer();
    
    solverTranslator.translate(solver, nnConfigBuilderContainer);
    netTranslator.translate(net, nnConfigBuilderContainer);
    
    Graph<CaffeNode> graph = new CaffeLayerGraphConversion(net).convert();
    
    DL4jCaffeNetCreator creator = new DL4jCaffeNetCreator();
    
    MultiLayerNetwork network = creator.createNet(nnConfigBuilderContainer, graph);
    
    prn("Created network " + network.getClass().toString() + "@" + network.toString());
    prn("Layers:");
    
    for(String lname : network.getLayerNames()) {
      Layer lay = network.getLayer(lname);
      prn(lname + " : " + lay.type().toString() + " @ " + lay.toString());
    }
    
  }

  
}
