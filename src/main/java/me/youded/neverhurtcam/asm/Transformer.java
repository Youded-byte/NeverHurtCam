package me.youded.neverhurtcam.asm;

import java.lang.instrument.ClassFileTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

import me.youded.neverhurtcam.config.Config;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassWriter;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Transformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (classfileBuffer == null || classfileBuffer.length == 0) {
            return new byte[0];
        }

        ClassReader cr = new ClassReader(classfileBuffer);
        if (cr.getAccess() == Opcodes.ACC_SUPER + Opcodes.ACC_PUBLIC) {
            ClassNode cn = new ClassNode();

            cr.accept(cn, 0);

            for (MethodNode method : cn.methods) {
                if (method.desc.endsWith("F)V")) {
                    int amountofeightthousand = 0;
                    int amountoffourteen = 0;
                    for (AbstractInsnNode insn : method.instructions) {
                        if (insn.getOpcode() == Opcodes.LDC && ((LdcInsnNode) insn).cst.equals(14.0F)) {
                            amountoffourteen++;
                        }
                        if (insn.getOpcode() == Opcodes.LDC && ((LdcInsnNode) insn).cst.equals(8000.0F)) {
                            amountofeightthousand++;
                        }
                    }
                    if (amountoffourteen == 1 && amountofeightthousand == 1) {
                        for (AbstractInsnNode insn : method.instructions) {
                            if (insn.getOpcode() == Opcodes.LDC && ((LdcInsnNode) insn).cst.equals(14.0F)) {
                                method.instructions.set(insn, new LdcInsnNode(Config.hurtfloat));
                                ClassWriter cw = new ClassWriter(cr, 0);
                                cn.accept(cw);
                                return cw.toByteArray();
                            }
                        }
                    }
                }
            }
        }
        return classfileBuffer;
    }
}
