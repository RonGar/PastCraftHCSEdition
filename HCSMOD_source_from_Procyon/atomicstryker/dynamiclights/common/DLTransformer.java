// 
// Decompiled by Procyon v0.5.36
// 

package atomicstryker.dynamiclights.common;

import java.util.ListIterator;
import java.util.Iterator;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import net.minecraft.launchwrapper.IClassTransformer;

public class DLTransformer implements IClassTransformer
{
    private final String classNameWorldObfusc = "abw";
    private final String classNameBlockAccessObfusc = "acf";
    private final String computeLightValueMethodNameO = "a";
    private final String enumSkyBlockObfusc = "ach";
    private final String classNameWorld = "cuqu";
    private final String blockAccessJava = "dxti";
    private final String computeLightValueMethodName = "computeLightValue";
    
    public byte[] transform(final String s, final String s2, final byte[] array) {
        if (s.equals("abw")) {
            return this.handleWorldTransform(array, true);
        }
        if (s.equals("cuqu")) {
            return this.handleWorldTransform(array, false);
        }
        return array;
    }
    
    private byte[] handleWorldTransform(final byte[] array, final boolean b) {
        System.out.println("**************** Dynamic Lights transform running on World *********************** ");
        final ClassNode classNode = new ClassNode();
        new ClassReader(array).accept((ClassVisitor)classNode, 0);
        for (final MethodNode methodNode : classNode.methods) {
            if (methodNode.name.equals(b ? "a" : "computeLightValue") && methodNode.desc.equals(b ? "(IIILach;)I" : "(IIILnet/minecraft/world/EnumSkyBlock;)I")) {
                System.out.println("In target method! Patching!");
                AbstractInsnNode obj = null;
                final ListIterator iterator2 = methodNode.instructions.iterator();
                boolean b2 = false;
                boolean b3 = false;
                while (iterator2.hasNext()) {
                    obj = iterator2.next();
                    if (obj instanceof VarInsnNode) {
                        final VarInsnNode varInsnNode = (VarInsnNode)obj;
                        if (varInsnNode.var == 6) {
                            if (varInsnNode.getOpcode() == 58) {
                                System.out.println("Bytecode ASTORE 6 case!");
                                b2 = true;
                                continue;
                            }
                            if (varInsnNode.getOpcode() == 54) {
                                System.out.println("Bytecode ISTORE 6 case!");
                                b3 = true;
                                obj = iterator2.next();
                                break;
                            }
                        }
                        if (varInsnNode.var == 7 && b2) {
                            break;
                        }
                    }
                    if (b2) {
                        System.out.println("Removing " + obj);
                        iterator2.remove();
                    }
                }
                final InsnList list = new InsnList();
                list.add((AbstractInsnNode)new VarInsnNode(25, 0));
                list.add((AbstractInsnNode)new VarInsnNode(21, 5));
                list.add((AbstractInsnNode)new VarInsnNode(21, 1));
                list.add((AbstractInsnNode)new VarInsnNode(21, 2));
                list.add((AbstractInsnNode)new VarInsnNode(21, 3));
                list.add((AbstractInsnNode)new MethodInsnNode(184, "hcsmod/flashlight/FlashlightClient", "getLightValue", "(L" + (b ? "acf" : "dxti") + ";IIII)I"));
                if (b3) {
                    list.add((AbstractInsnNode)new VarInsnNode(54, 6));
                }
                methodNode.instructions.insertBefore(obj, list);
                System.out.println("Patching Complete!");
                break;
            }
        }
        final ClassWriter classWriter = new ClassWriter(3);
        classNode.accept((ClassVisitor)classWriter);
        return classWriter.toByteArray();
    }
}
