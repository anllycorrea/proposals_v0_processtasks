/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbva.pzic.proposals.util.orika.inheritance;

import com.bbva.pzic.proposals.util.orika.metadata.Type;

public abstract class DefaultSuperTypeResolverStrategy implements SuperTypeResolverStrategy {

	public abstract boolean isAcceptable(Type<?> type);
	
	public boolean accept(Type<?> type) {
		return isAcceptable(type);
	}

	public boolean shouldLookupSuperType(Type<?> type) {
		return !isAcceptable(type);
	}

	public boolean shouldPreferClassOverInterface() {
		return true;
	}
};
