package com.studentTracer.dao;

import java.util.HashMap;

import com.studentTracer.beans.Sequence;

public interface SequenceDAO {
	
	HashMap<Long, Sequence> rechercherSequences();
}
