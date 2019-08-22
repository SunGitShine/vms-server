package com.juma.vms.tool.service.impl;

import com.juma.vms.common.id.IdGeneratorTable;
import com.juma.vms.tool.dao.IdGeneratorMapper;
import com.juma.vms.tool.service.IdGeneratorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class IdGeneratorServiceImpl implements IdGeneratorService {

    @Resource
    private IdGeneratorMapper idGeneratorMapper;

    @Override
    public String genId(IdGeneratorTable.IdType idType) {
        if (idType == null) return null;
        StringBuilder sequence = new StringBuilder(idType.name());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String df = dateFormat.format(new Date());
        sequence.append(df);
        Integer id = idGeneratorMapper.genId(idType.getTableName());//
        Integer random = ThreadLocalRandom.current().nextInt(100, 999);
        sequence.append(random);
        DecimalFormat format = new DecimalFormat("000000");
        sequence.append(format.format(id == null ? 0 : id % 100000));
        return sequence.toString();
    }

    @Override
    public String genTransportSendNo(IdGeneratorTable.IdType idType) {
        if (idType == null) return null;
        StringBuilder sequence = new StringBuilder(idType.name());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String df = dateFormat.format(new Date());
        sequence.append(df);
        Integer id = idGeneratorMapper.genId(idType.getTableName());
        sequence.append(leftPad(id + "", 4, '0'));
        return sequence.toString();
    }

    public static void main(String[] args) {
        System.out.println(leftPad("ABCDEF", 5, 'x'));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMM");
        String df = dateFormat.format(new Date());
        System.out.println(df);
    }

    private static String leftPad(String originalString, int length, char padCharacter) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = padCharacter + paddedString;
        }
        return paddedString;
    }

    @Override
    public Integer excuteSQL(String sql) {
        return idGeneratorMapper.excuteSQL(sql);
    }
}
