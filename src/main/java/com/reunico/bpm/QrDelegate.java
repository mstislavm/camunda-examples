package com.reunico.bpm;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.FileValue;
import java.io.InputStream;



public class QrDelegate implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
        FileValue qrFile = runtimeService.getVariableTyped(execution.getId(), "qrFile");
        InputStream inputStream = qrFile.getValue();
        try {
            QrReader qrReader = new QrReader();
            String qrCode = qrReader.decodeQRCode(inputStream);
            execution.setVariable("qrCode", qrCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
