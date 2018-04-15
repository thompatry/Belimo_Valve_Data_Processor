package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		//Set the two PATH strings as a constant variable that can never be changed
		final String INPUT_PATH = "C:\\history\\18apr7\\";
		final String OUTPUT_PATH = "C:\\valve_data\\";
		//Initialize the variable line as a string
		String line = "";
		//Initialize a list composed of strings called inputData. 
		List<String> inputData = new ArrayList<String>();
		
		//Initialize a string called csvFiles that can be 24 chars long		
		String[] csvFiles = new String[24];

		for (int i = 0; i < 24; i++) {
			csvFiles[i] = INPUT_PATH + Integer.toString(i) + ".csv";
		}

		System.out.println("Cleaning the output directory...");
		File[] oldFiles = new File(OUTPUT_PATH).listFiles();
		for (File f : oldFiles) {
			if (f.isFile() && f.exists()) {
				f.delete();
			}
		}
		System.out.println("Done cleaning the output directory...");

		System.out.println("Reading input files...");
		for (String file : csvFiles) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				br.readLine();
				while ((line = br.readLine()) != null) {
					inputData.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading input files...");

		while (inputData.size() > 0) {
			StringBuilder writeToFile = new StringBuilder();
			List<String> valve = new ArrayList<String>();
			String[] tempLine = inputData.get(0).split(",");
			String[] tempValveAndProp = tempLine[3].split("_");
			String valveName;
			Boolean longValve = false;
			if (tempValveAndProp.length <= 4) {
				valveName = tempValveAndProp[0] + "_" + tempValveAndProp[1] + "_" + tempValveAndProp[2];
			} else {
				longValve = true;
				valveName = tempValveAndProp[0] + "_" + tempValveAndProp[1] + "_" + tempValveAndProp[2] + "_"
						+ tempValveAndProp[3];
			}

			System.out.println("Processing data for valve: " + valveName);

			writeToFile.append(
					"Default DataLog Configuration\n");
			
			writeToFile.append(
					"Timestamp - UTC,2.In0: Mean ControlMode_(0=PosCtrl|1=FlowCtrl|2=PowCtrl),2.In0: StdDev ControlMode_(0=PosCtrl|1=FlowCtrl|2=PowCtrl),2.In0: Min ControlMode_(0=PosCtrl|1=FlowCtrl|2=PowCtrl),2.In0: Max ControlMode_(0=PosCtrl|1=FlowCtrl|2=PowCtrl),2.In1: Mean Override_(1=Auto|2=Close|3=Open|4=VNom|5=VMax|6=MotorStop|7=PNom|8=Pmax|9=SpPosOvwrt|10=InputSim),2.In1: StdDev Override_(1=Auto|2=Close|3=Open|4=VNom|5=VMax|6=MotorStop|7=PNom|8=Pmax|9=SpPosOvwrt|10=InputSim),2.In1: Min Override_(1=Auto|2=Close|3=Open|4=VNom|5=VMax|6=MotorStop|7=PNom|8=Pmax|9=SpPosOvwrt|10=InputSim),2.In1: Max Override_(1=Auto|2=Close|3=Open|4=VNom|5=VMax|6=MotorStop|7=PNom|8=Pmax|9=SpPosOvwrt|10=InputSim),2.In2: Mean DeltaT_Limit_(0=standby|1=active),2.In2: StdDev DeltaT_Limit_(0=standby|1=active),2.In2: Min DeltaT_Limit_(0=standby|1=active),2.In2: Max DeltaT_Limit_(0=standby|1=active),2.In3: Mean Install_Pos_(0=Return_Flow|1=Supply_Flow),2.In3: StdDev Install_Pos_(0=Return_Flow|1=Supply_Flow),2.In3: Min Install_Pos_(0=Return_Flow|1=Supply_Flow),2.In3: Max Install_Pos_(0=Return_Flow|1=Supply_Flow),2.In4: Mean SpRel_[%],2.In4: StdDev SpRel_[%],2.In4: Min SpRel_[%],2.In4: Max SpRel_[%],2.In5: Mean RelPos_Sp_[%],2.In5: StdDev RelPos_Sp_[%],2.In5: Min RelPos_Sp_[%],2.In5: Max RelPos_Sp_[%],2.In6: Mean RelPos_Fb_[%],2.In6: StdDev RelPos_Fb_[%],2.In6: Min RelPos_Fb_[%],2.In6: Max RelPos_Fb_[%],2.In7: Mean RelPower_Fb_ [%ofPmax],2.In7: StdDev RelPower_Fb_ [%ofPmax],2.In7: Min RelPower_Fb_ [%ofPmax],2.In7: Max RelPower_Fb_ [%ofPmax],2.In8: Mean RelFlow_Sp_[%ofVMax],2.In8: StdDev RelFlow_Sp_[%ofVMax],2.In8: Min RelFlow_Sp_[%ofVMax],2.In8: Max RelFlow_Sp_[%ofVMax],2.In9: Mean RelFlow_Fb_[%ofVMax],2.In9: StdDev RelFlow_Fb_[%ofVMax],2.In9: Min RelFlow_Fb_[%ofVMax],2.In9: Max RelFlow_Fb_[%ofVMax],2.In10: Mean AbsFlow_[XX],2.In10: StdDev AbsFlow_[XX],2.In10: Min AbsFlow_[XX],2.In10: Max AbsFlow_[XX],2.In11: Mean UnitFlow_(0=m3/h|1=l/s|2=l/min|3=l/h|4=GPM),2.In11: StdDev UnitFlow_(0=m3/h|1=l/s|2=l/min|3=l/h|4=GPM),2.In11: Min UnitFlow_(0=m3/h|1=l/s|2=l/min|3=l/h|4=GPM),2.In11: Max UnitFlow_(0=m3/h|1=l/s|2=l/min|3=l/h|4=GPM),2.In12: Mean null,2.In12: StdDev null,2.In12: Min null,2.In12: Max null,2.In13: Mean T1_remote_[XX],2.In13: StdDev T1_remote_[XX],2.In13: Min T1_remote_[XX],2.In13: Max T1_remote_[XX],2.In14: Mean UnitTemp_(0=C|1=F),2.In14: StdDev UnitTemp_(0=C|1=F),2.In14: Min UnitTemp_(0=C|1=F),2.In14: Max UnitTemp_(0=C|1=F),2.In15: Mean T2_embedded_[XX],2.In15: StdDev T2_embedded_[XX],2.In15: Min T2_embedded_[XX],2.In15: Max T2_embedded_[XX],2.In16: Mean UnitTemp_(0=C|1=F),2.In16: StdDev UnitTemp_(0=C|1=F),2.In16: Min UnitTemp_(0=C|1=F),2.In16: Max UnitTemp_(0=C|1=F),2.In17: Mean DeltaT_[XX],2.In17: StdDev DeltaT_[XX],2.In17: Min DeltaT_[XX],2.In17: Max DeltaT_[XX],2.In18: Mean UnitTemp_(0=C|1=F),2.In18: StdDev UnitTemp_(0=C|1=F),2.In18: Min UnitTemp_(0=C|1=F),2.In18: Max UnitTemp_(0=C|1=F),2.In19: Mean Power_[XX],2.In19: StdDev Power_[XX],2.In19: Min Power_[XX],2.In19: Max Power_[XX],2.In20: Mean UnitPower_(0=W|1=kW|2=BTU/h|3=kBTU/h|4=Ton),2.In20: StdDev UnitPower_(0=W|1=kW|2=BTU/h|3=kBTU/h|4=Ton),2.In20: Min UnitPower_(0=W|1=kW|2=BTU/h|3=kBTU/h|4=Ton),2.In20: Max UnitPower_(0=W|1=kW|2=BTU/h|3=kBTU/h|4=Ton),2.In21: Mean Heating_E_[XX],2.In21: StdDev Heating_E_[XX],2.In21: Min Heating_E_[XX],2.In21: Max Heating_E_[XX],2.In22: Mean Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In22: StdDev Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In22: Min Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In22: Max Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In23: Mean Cooling_E_[XX],2.In23: StdDev Cooling_E_[XX],2.In23: Min Cooling_E_[XX],2.In23: Max Cooling_E_[XX],2.In24: Mean Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In24: StdDev Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In24: Min Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In24: Max Unit-Energy_(0=kWh|1=MWh|2=kBTU|3=TonH|4=MJ|5=GJ),2.In25: Mean DeltaT_Limit_(0=disabled|1=energy|2=comfort),2.In25: StdDev DeltaT_Limit_(0=disabled|1=energy|2=comfort),2.In25: Min DeltaT_Limit_(0=disabled|1=energy|2=comfort),2.In25: Max DeltaT_Limit_(0=disabled|1=energy|2=comfort),2.In26: Mean DeltaT_Sp_[XX],2.In26: StdDev DeltaT_Sp_[XX],2.In26: Min DeltaT_Sp_[XX],2.In26: Max DeltaT_Sp_[XX],2.In27: Mean Fb_Output_0-10V_[%],2.In27: StdDev Fb_Output_0-10V_[%],2.In27: Min Fb_Output_0-10V_[%],2.In27: Max Fb_Output_0-10V_[%],2.In28: Mean Vmax_[%],2.In28: StdDev Vmax_[%],2.In28: Min Vmax_[%],2.In28: Max Vmax_[%],2.In29: Mean Pmax_[%],2.In29: StdDev Pmax_[%],2.In29: Min Pmax_[%],2.In29: Max Pmax_[%],2.In30: Mean Valve_Code,2.In30: StdDev Valve_Code,2.In30: Min Valve_Code,2.In30: Max Valve_Code,2.In31: Mean QF-En,2.In31: StdDev QF-En,2.In31: Min QF-En,2.In31: Max QF-En,2.Out0: Mean RelPos_Fb_[%],2.Out0: StdDev RelPos_Fb_[%],2.Out0: Min RelPos_Fb_[%],2.Out0: Max RelPos_Fb_[%],2.Out1: Mean Sp=Fb_(0=false|1=true),2.Out1: StdDev Sp=Fb_(0=false|1=true),2.Out1: Min Sp=Fb_(0=false|1=true),2.Out1: Max Sp=Fb_(0=false|1=true),2.Out2: Mean T1remote_[Ohm],2.Out2: StdDev T1remote_[Ohm],2.Out2: Min T1remote_[Ohm],2.Out2: Max T1remote_[Ohm],2.Out3: Mean T2embedded_[Ohm],2.Out3: StdDev T2embedded_[Ohm],2.Out3: Min T2embedded_[Ohm],2.Out3: Max T2embedded_[Ohm],2.Out4: Mean Sp_Input_[V],2.Out4: StdDev Sp_Input_[V],2.Out4: Min Sp_Input_[V],2.Out4: Max Sp_Input_[V],2.Out5: Mean FlowSens_[mA|l/min],2.Out5: StdDev FlowSens_[mA|l/min],2.Out5: Min FlowSens_[mA|l/min],2.Out5: Max FlowSens_[mA|l/min],2.Out6: Mean MP1_Alive_(0=false|1=true),2.Out6: StdDev MP1_Alive_(0=false|1=true),2.Out6: Min MP1_Alive_(0=false|1=true),2.Out6: Max MP1_Alive_(0=false|1=true),2.Out7: Mean MP2_Alive_(0=false|1=true),2.Out7: StdDev MP2_Alive_(0=false|1=true),2.Out7: Min MP2_Alive_(0=false|1=true),2.Out7: Max MP2_Alive_(0=false|1=true),2.Out8: Mean BPosG,2.Out8: StdDev BPosG,2.Out8: Min BPosG,2.Out8: Max BPosG,2.Out9: Mean QF-ErrSte,2.Out9: StdDev QF-ErrSte,2.Out9: Min QF-ErrSte,2.Out9: Max QF-ErrSte,2.Out10: Mean GlycolType_(0=Ethylene|1=Propylene),2.Out10: StdDev GlycolType_(0=Ethylene|1=Propylene),2.Out10: Min GlycolType_(0=Ethylene|1=Propylene),2.Out10: Max GlycolType_(0=Ethylene|1=Propylene),2.Out11: Mean GlycolConcentration_[%],2.Out11: StdDev GlycolConcentration_[%],2.Out11: Min GlycolConcentration_[%],2.Out11: Max GlycolConcentration_[%]\n");

			List<String> templist = new ArrayList<String>();
			for (String register : inputData) {
				if (register.contains(valveName)) {
					valve.add(register);
				} else {
					templist.add(register);
				}
			}
			inputData = templist;

			while (valve.size() > 0) {
				templist = new ArrayList<String>();
				String timeStamp = valve.get(0).split(",")[2];
				String[] lineToWrite = { timeStamp, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
				for (String register : valve) {
					if (register.contains(timeStamp)) {
						int propertyIndex = longValve ? 4 : 3;
						String property = register.split(",")[3].split("_")[propertyIndex];
						String value = register.split(",")[4];
						parseProperty(lineToWrite, property, value);
					} else {
						templist.add(register);
					}
				}
				valve = templist;
				for (int i = 0; i < lineToWrite.length; i++) {
					if (!lineToWrite[i].isEmpty()) {
						if (i != lineToWrite.length - 1)
							writeToFile.append(lineToWrite[i] + ",");
						else
							writeToFile.append(lineToWrite[i] + "\n");
					} else {
						if (i != lineToWrite.length - 1)
							writeToFile.append(",");
						else
							writeToFile.append("\n");
					}
				}
			}
			String fileName = OUTPUT_PATH + valveName + ".csv";
			System.out.println("Done processing data for valve: " + valveName + ". Writing data to: " + fileName);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(writeToFile.toString());
			writer.close();
		}
		System.out.println("Finished processing all valves!");
	}
	
	private static String string2int2string(String value) {
		int tempValue;
		tempValue = Integer.parseInt(value);
		tempValue = tempValue--;
		value = String.valueOf(tempValue);
		return value;
	}

	private static void parseProperty(String[] line, String property, String value) {
		switch (property) {
		case "CtrlMd":
			value = string2int2string(value);
			line[1] = value;
			break;
		case "DeltaTMgrSts":
			value = string2int2string(value);
			line[9] = value;
			break;
		case "RelPos":
			line[21] = value;
			break;
		case "RelPower":
			line[29] = value;
			break;
		case "RelFlow":
			line[33] = value;
			break;
		case "AbsFlow":
			line[41] = value;
			break;
		case "EnteringTmp":
			line[53] = value;
			break;
		case "LeavingTmp":
			line[61] = value;
			break;
		case "DeltaT":
			line[69] = value;
			break;
		case "AbsPower":
			line[77] = value;
			break;
		case "HtgEnergy":
			line[85] = value;
			break;
		case "ClgEnergy":
			line[93] = value;
			break;
		case "DeltaTLimitation":
			value = string2int2string(value);
			line[101] = value;
			break;
		case "DeltaTSp":
			line[105] = value;
			break;
		case "Vmax":
			line[113] = value;
			break;
		case "Vnom":
			line[149] = value;
			break;
		}
	}
}
