package de.fhg.iais.roberta.syntax.sensor.bob3;

import de.fhg.iais.roberta.blockly.generated.Block;
import de.fhg.iais.roberta.factory.IRobotFactory;
import de.fhg.iais.roberta.inter.mode.sensor.ISensorPort;
import de.fhg.iais.roberta.syntax.BlockTypeContainer;
import de.fhg.iais.roberta.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.syntax.BlocklyComment;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.sensor.BaseSensor;
import de.fhg.iais.roberta.transformer.Jaxb2AstTransformer;
import de.fhg.iais.roberta.transformer.JaxbTransformerHelper;
import de.fhg.iais.roberta.visitor.AstVisitor;
import de.fhg.iais.roberta.visitor.Bob3AstVisitor;

/**
 * This class represents the <b>robSensors_touch_isPressed</b> blocks from Blockly into
 * the AST (abstract syntax
 * tree).
 * Object from this class will generate code for checking if the sensor is pressed.<br/>
 * <br>
 * The client must provide the {@link SensorPort}.<br>
 * <br>
 * To create an instance from this class use the method {@link #make(SensorPort, BlocklyBlockProperties, BlocklyComment)}.<br>
 */
public class LightSensor<V> extends BaseSensor<V> {

    private LightSensor(BlocklyBlockProperties properties, BlocklyComment comment) {
        super(null, BlockTypeContainer.getByName("BOB3_IRLIGHT"), properties, comment);
        setReadOnly();
    }

    /**
     * Create object of the class {@link LightSensor}.
     *
     * @param port on which the sensor is connected; must be <b>not</b> null; see enum {@link SensorPort} for all possible ports that the sensor can be
     *        connected,
     * @param properties of the block (see {@link BlocklyBlockProperties}),
     * @param comment added from the user,
     * @return read only object of {@link LightSensor}
     */
    public static <V> LightSensor<V> make(ISensorPort port, BlocklyBlockProperties properties, BlocklyComment comment) {
        return new LightSensor<V>(properties, comment);
    }

    @Override
    public String toString() {
        return "TouchSensor [port=" + getPort() + "]";
    }

    @Override
    protected V accept(AstVisitor<V> visitor) {
        return ((Bob3AstVisitor<V>) visitor).visitLightSensor(this);
    }

    /**
     * Transformation from JAXB object to corresponding AST object.
     *
     * @param block for transformation
     * @param helper class for making the transformation
     * @return corresponding AST object
     */
    public static <V> Phrase<V> jaxbToAst(Block block, Jaxb2AstTransformer<V> helper) {
        IRobotFactory factory = helper.getModeFactory();
        return LightSensor.make(null, helper.extractBlockProperties(block), helper.extractComment(block));
    }

    @Override
    public Block astToBlock() {
        Block jaxbDestination = new Block();
        JaxbTransformerHelper.setBasicProperties(this, jaxbDestination);
        return jaxbDestination;
    }
}
